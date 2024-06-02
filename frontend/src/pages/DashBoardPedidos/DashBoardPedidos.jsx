import * as S from './styles';
import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { pedidoService } from '../../services/pedido.service';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaTrashAlt } from 'react-icons/fa';
import moment from 'moment';

export function DashBoardPedidos() {
  const [pedidos, setPedidos] = useState([]);
  const [idPedido, setIdPedido] = useState('');
  const navigate = useNavigate();

  const [paginaAtual, setPaginaAtual] = useState(0);
  const [tamanhoPagina, setTamanhoPagina] = useState(10);
  const [totalPaginas, setTotalPaginas] = useState(1);

  const proximaPagina = () => {
    if (paginaAtual < totalPaginas - 1) {
      setPaginaAtual(paginaAtual + 1);
      buscarPedidos();
    }
  };

  const paginaAnterior = () => {
    if (paginaAtual > 0) {
      setPaginaAtual(paginaAtual - 1);
      buscarPedidos();
    }
  };

  const cadastroPedido = () => {
    navigate('/adminpedidos'); // Ajuste a rota se necessário
  };

  async function buscarPedidos() {
    try {
      const data = await pedidoService.findAllPedidos(paginaAtual, tamanhoPagina, 'codPedido', 'asc');
      setPedidos(data.content);
      setTotalPaginas(data.totalPages);
    } catch (error) {
      console.error('Erro ao buscar pedidos:', error);
      toast.error('Erro ao buscar pedidos. Tente novamente mais tarde.');
    }
  };

  async function buscarPedidoPorId() {
    try {
      const pedido = await pedidoService.findPedidoById(idPedido);
      setPedidos([pedido]);
    } catch (error) {
      console.error('Erro ao buscar pedido por ID:', error);
      toast.error('Erro ao buscar pedido por ID. Verifique o código informado.');
    }
  }

  async function deletarPedido(id) {
    if (window.confirm("Tem certeza que deseja deletar este pedido?")) {
      try {
        await pedidoService.deleteById(id);
        toast.success('Pedido deletado com sucesso.');
        buscarPedidos();
      } catch (error) {
        console.error(`Erro ao deletar pedido com ID ${id}:`, error);
        toast.error('Erro ao deletar pedido.');
      }
    }
  }

  useEffect(() => {
    buscarPedidos();
  }, [paginaAtual]); // Buscar ao mudar a página

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
            placeholder="Código do Pedido"
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
              <th>Código do Cliente</th>
              <th>Data do Pedido</th>
              <th>Data de Envio</th>
              <th>Data de Entrega</th>
              <th>Status</th>
              <th>Método de Pagamento</th>
              <th>Sub Total</th>
              <th>Taxa de Envio</th>
              <th>Código de Rastreamento</th>
              <th>Ações</th>
            </tr>
          </thead>

          <tbody>
            {Array.isArray(pedidos) && pedidos.map((pedido) => (
              <tr key={pedido.codPedido}>
                <td>{pedido.codPedido}</td>
                <td>{pedido.codCliente}</td>
                <td>{moment(pedido.dtPedido).format('DD/MM/YYYY')}</td>
                <td>{pedido.dtEnvio ? moment(pedido.dtEnvio).format('DD/MM/YYYY') : '-'}</td>
                <td>{pedido.dtEntrega ? moment(pedido.dtEntrega).format('DD/MM/YYYY') : '-'}</td>
                <td>{pedido.status}</td>
                <td>{pedido.mtdPagamento}</td>
                <td>{pedido.subtotal}</td>
                <td>{pedido.taxaEnvio}</td>
                <td>{pedido.codigoRastreamento || '-'}</td>
                <td className='tdLixeira'>
                  <button type="button" onClick={() => deletarPedido(pedido.codPedido)}>
                    <FaTrashAlt className='iconLixeira' />
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