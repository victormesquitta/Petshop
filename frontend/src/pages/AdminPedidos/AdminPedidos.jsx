import { FaArrowLeft, FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilDog from '../../assets/images/ImgPerfilDog.png'
import * as S from './styles';
import { useEffect, useState } from 'react';
import { toast, ToastContainer } from 'react-toastify'; // Importe o toast
import 'react-toastify/dist/ReactToastify.css'; // Importe o CSS do toast
import { pedidoService } from '../../services/pedido.service';


export function AdminPedidos() {
    const [pedidos, setPedidos] = useState([]);
    const [idPedido, setIdPedido] = useState('');
    const [codCliente, setCodCliente] = useState('');
    const [dtPedido, setDtPedido] = useState('');
    const [dtEnvio, setDtEnvio] = useState('');
    const [dtEntrega, setDtEntrega] = useState('');
    const [status, setStatus] = useState('');
    const [mtdPagamento, setMtdPagamento] = useState('');
    const [subtotal, setSubtotal] = useState('');
    const [taxaEnvio, setTaxaEnvio] = useState('');
    const [codigoRastreamento, setCodigoRastreamento] = useState('');


    async function buscarPedidos() {
        try {
            const data = await pedidoService.findAllPedidos();
            setPedidos(data.content);
        } catch (error) {
            console.error('Erro ao buscar pedidos:', error);
            toast.error('Erro ao buscar pedidos:', error);
        }
    };


    async function atualizarPedido() {
        // 1. Validação dos campos do pedido
        if (!idPedido || !codCliente || !dtPedido || !dtEnvio || !dtEntrega || !status || !mtdPagamento || !subtotal || !taxaEnvio || !codigoRastreamento) {
            toast.error('Preencha todos os campos!');
            return;
        }

        const pedidoAtualizado = {
            codPedido: parseInt(idPedido, 10),
            codCliente: parseInt(codCliente, 10),
            dtPedido: dtPedido,
            dtEnvio: dtEnvio,
            dtEntrega: dtEntrega,
            status: status,
            mtdPagamento: mtdPagamento,
            subtotal: parseFloat(subtotal),
            taxaEnvio: parseFloat(taxaEnvio),
            codigoRastreamento: codigoRastreamento
        };

        try {
            await pedidoService.update(idPedido, pedidoAtualizado);
            toast.success(`Pedido com ID ${idPedido} atualizado com sucesso!`);
            // Limpe os campos do formulário
            // ...
            buscarPedidos();
        } catch (error) {
            console.error(`Erro ao atualizar pedido com ID ${idPedido}:`, error);
            toast.error(`Erro ao atualizar pedido com ID ${idPedido}: ${error.message}`);
        }
    }

    async function criarPedido() {
        // 1. Validação dos campos do pedido (codCliente, status, etc.)
        if (!codCliente || !status || !mtdPagamento || !subtotal || !taxaEnvio) {
            toast.error('Preencha todos os campos obrigatórios!');
            return;
        }

        const novoPedido = {
            codCliente: parseInt(codCliente, 10),
            dtPedido: dtPedido, // Você pode querer definir uma data padrão aqui
            dtEnvio: dtEnvio,     // ou no backend
            dtEntrega: dtEntrega,   // ou no backend
            status: status,
            mtdPagamento: mtdPagamento,
            subtotal: parseFloat(subtotal),
            taxaEnvio: parseFloat(taxaEnvio),
            codigoRastreamento: codigoRastreamento
        };

        try {
            await pedidoService.create(novoPedido);
            toast.success('Pedido criado com sucesso!');

            setCodCliente('');
            setDtPedido('');
            setDtEnvio('');
            setDtEntrega('');
            setStatus('');
            setMtdPagamento('');
            setSubtotal('');
            setTaxaEnvio('');
            setCodigoRastreamento('');

            buscarPedidos();
        } catch (error) {
            console.error('Erro ao criar pedido:', error);
            toast.error('Erro ao criar pedido. Verifique os dados e tente novamente.');
        }
    }

    async function deletarPedido(id) {
        if (!id) {
            toast.error('Digite um ID para deletar!');
            return;
        }

        try {
            await pedidoService.deleteById(id);
            toast.success(`Pedido com ID ${id} deletado com sucesso.`);
            buscarPedidos();
        } catch (error) {
            console.error(`Erro ao deletar pedido com ID ${id}:`, error);
            toast.error(`Erro ao deletar pedido com ID ${id}: ${error.message}`);
        }
    }

    useEffect(() => {
        buscarPedidos();
    }, []);

    return (
        <>
            <S.ContainerPai>
                <ToastContainer className='toastContainer' />
                <div className='divDashBoard'>
                    <img src={ImgLogo} />

                    <h1>DashBoard</h1>

                    <Link to={'/dashboardpedidos'} className='Link'><FaArrowLeft className='icons' /> Voltar</Link>

                </div>

                <div className='divPrincipal'>
                    <section className='section1'>
                        <input placeholder='Pesquisar' className='InputPesquisar' />
                        <FaSearch className="IconLupa" />

                        <img src={ImgPerfilDog} />
                    </section>

                    <div className='divSections'>
                        <section className='section2'>
                            <h1>Novo Produto</h1>

                            <label htmlFor="codCliente">Código do Cliente:</label>
                            <input
                                type="number"
                                id="codCliente"
                                value={codCliente}
                                onChange={e => setCodCliente(e.target.value)}
                            />

                            {/* Adicione os outros campos do pedido aqui */}
                            <label htmlFor="status">Status:</label>
                            <input
                                type="text"
                                id="status"
                                value={status}
                                onChange={e => setStatus(e.target.value)}
                            />

                            <label htmlFor="mtdPagamento">Método de Pagamento:</label>
                            <input
                                type="text"
                                id="mtdPagamento"
                                value={mtdPagamento}
                                onChange={e => setMtdPagamento(e.target.value)}
                            />

                            <label htmlFor="subtotal">Subtotal:</label>
                            <input
                                type="number"
                                id="subtotal"
                                value={subtotal}
                                onChange={e => setSubtotal(e.target.value)}
                            />

                            <label htmlFor="taxaEnvio">Taxa de Envio:</label>
                            <input
                                type="number"
                                id="taxaEnvio"
                                value={taxaEnvio}
                                onChange={e => setTaxaEnvio(e.target.value)}
                            />

                            <label htmlFor="codigoRastreamento">Código de Rastreamento:</label>
                            <input
                                type="text"
                                id="codigoRastreamento"
                                value={codigoRastreamento}
                                onChange={e => setCodigoRastreamento(e.target.value)}
                            />
                        </section>
                    </div>

                    <section className='section3'>
                        <input
                            type='number'
                            placeholder='ID do Pedido'
                            value={idPedido}
                            onChange={e => setIdPedido(e.target.value)}
                        />
                        <button type='button' onClick={() => deletarPedido(idPedido)}>
                            Deletar por ID
                        </button>
                        <button type='button' onClick={atualizarPedido}>
                            Atualizar por ID
                        </button>
                        <button type='button' onClick={criarPedido}>
                            Criar Pedido
                        </button>
                    </section>
                </div>
            </S.ContainerPai>
        </>
    );
}