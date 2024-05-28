import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { pedidoService } from '../../services/pedido.service'; // Importe o serviço de pedido
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaTrashAlt } from 'react-icons/fa';


export function DashBoardPedidos() {
  const [pedidos, setPedidos] = useState([]);
  const [idPedido, setIdPedido] = useState('');
  const navigate = useNavigate();

  // Estado da paginação
  const [paginaAtual, setPaginaAtual] = useState(0); // Começa na página 0
  const [tamanhoPagina, setTamanhoPagina] = useState(10); // Tamanho da página
  const [totalPaginas, setTotalPaginas] = useState(1); // Total de páginas

  // Funções para controlar a navegação
  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
      buscarPedidos(); // Busca os dados da próxima página
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
    }
  };

  const cadastroPedido = () => {
    navigate('/cadastroPedido')
  };

  async function buscarPedidos() {
    try {
      const data = await pedidoService.findAllPedidos(paginaAtual, tamanhoPagina, 'codPedido', 'asc'); // Adapte para o serviço de pedidos
      setPedidos(data.content);
      setTotalPaginas(data.totalPages);
    } catch (error) {
      console.error('Erro ao buscar pedidos:', error);
      toast.error('Erro ao buscar pedidos. Tente novamente mais tarde.');
    }
  };

  async function buscarPedidoPorId() {
    try {
      const pedido = await pedidoService.findPedidoById(idPedido); // Adapte para o serviço de pedidos
      // Adicione o pedido encontrado à lista atual
      setPedidos([pedido]);
    } catch (error) {
      console.error('Erro ao buscar pedido por ID:', error);
      toast.error('Erro ao buscar pedido por ID:', error);
    }
  }

  async function deletarPedido(id) {
    if (window.confirm("Tem certeza que deseja deletar este pedido?")) { // Confirmação antes de deletar
      try {
        await pedidoService.deleteById(id); // Adapte para o serviço de pedidos
        toast.success('Pedido deletado com sucesso.');
        buscarPedidos(); // Atualiza a lista de pedidos
      } catch (error) {
        console.error(`Erro ao deletar pedido com ID ${id}:`, error);
        toast.error('Erro ao deletar pedido.');
      }
    }
  }

  useEffect(() => {
    buscarPedidos();
  }, [paginaAtual]);

  return (
    <S.ContainerPai>
      <ToastContainer className='toastContainer' />
      <div className='divDashBoard'>
        <h1>DashBoard</h1>

        <Link to={'/dashboardfuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
        <Link to={'/dashboardproduto'} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
        <Link to={'/dashboardcategoria'} className='Link'><FaList className='icons' /> Categoria</Link>
        <Link to={'/dashboardpedidos'} className='Link'><FaShippingFast className='icons' />Pedidos</Link>
        <Link to={'/dashboardsubcategoria'} className='Link'><FaList className='icons' /> Sub-Categoria</Link>
      </div>

      <div className='divPrincipal'>
        <section className='section1'>
          <input placeholder='Pesquisar' className='InputPesquisar' />
          <FaSearch className="IconLupa" />
        </section>

        <section className='sectionButtons'>
          <button type="button" onClick={buscarPedidos}>Buscar Todos</button>
          <input
            type="number"
            placeholder="Código do Pedido" // Altere o placeholder
            value={idPedido}
            onChange={e => setIdPedido(e.target.value)}
          />
          <button type="button" onClick={buscarPedidoPorId}>Buscar por ID</button>
          <button type="button" onClick={cadastroPedido}>Cadastrar Pedidos</button>
        </section>

        {/* Tabela de Pedidos */}
        <table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Data do Pedido</th>
              <th>Cliente</th>
              <th>Valor Total</th>
              <th>Status</th>
            </tr>
          </thead>

          <tbody>
            {Array.isArray(pedidos) && pedidos.map((pedido) => (
              <tr key={pedido.codPedido}>
                <td>{pedido.codPedido}</td>
                <td>{pedido.dataPedido}</td>
                <td>{pedido.cliente}</td>
                <td>{pedido.valorTotal}</td>
                <td>{pedido.status}</td>
                <td className='tdLixeira'>
                  {/* Botão de Deletar */}
                  <button type="button" onClick={() => deletarPedido(pedido.codPedido)}>
                    <FaTrashAlt className='iconLixeira' /> {/* Ícone de lixeira */}
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {/* Botões de paginação */}
        <div className='paginacao'>
          <button disabled={paginaAtual === 0} onClick={paginaAnterior}>Anterior</button>
          <span>Página {paginaAtual + 1} de {totalPaginas}</span>
          <button disabled={paginaAtual === totalPaginas - 1} onClick={proximaPagina}>Próxima</button>
        </div>
      </div>
    </S.ContainerPai>
  );
}