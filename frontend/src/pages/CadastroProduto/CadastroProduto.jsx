import { FaUserAlt, FaObjectGroup, FaList, FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilDog from '../../assets/images/ImgPerfilDog.png';
import * as S from './styles';
import { useState } from 'react';
import { produtoService } from '../../services/produto.service';
import { toast, ToastContainer } from 'react-toastify'; // Importe o toast
import 'react-toastify/dist/ReactToastify.css'; // Importe o CSS do toast


export function CadastroProduto() {
    const [produtos, setProdutos] = useState([]);
    const [idProduto, setIdProduto] = useState('');
    const [exibirProdutos, setExibirProdutos] = useState(false); // Estado para controlar a exibição
    const [dataCriacao, setDataCriacao] = useState('');
    const [disponivel, setDisponivel] = useState(null);
    const [promocao, setPromocao] = useState('');
    const [quantEstoque, setQuantEstoque] = useState('');
    const [precoProduto, setPrecoProduto] = useState('');
    const [descProduto, setDescProduto] = useState('');
    const [marcaProd, setMarcaProd] = useState('');
    const [nomeProd, setNomeProd] = useState('');
    const [codSubcategoria, setCodSubcategoria] = useState('');
    const [codProduto, setCodProduto] = useState('');


    async function atualizarProduto(id) {

        // 1. Validação de campos
        if (!id || !nomeProd || !marcaProd || !descProduto || !codCategoria || !precoProduto || !quantEstoque || !promocao || disponivel === null) {
            toast.error('Preencha todos os campos!');
            return;
        }

        // 2. Validação adicional (se necessário)
        if (parseInt(quantEstoque, 10) <= 0) {
            toast.error('Quantidade em estoque deve ser maior que zero!');
            return;
        }
        if (parseFloat(precoProduto) <= 0) {
            toast.error('Preço do produto deve ser maior que zero!');
            return;
        }

        const produtoAtualizado = {
            codProduto: id,
            dtCriacao: dataCriacao,
            disponivel: disponivel ? "true" : "false",
            promocao: promocao,
            qtdEstoque: parseInt(quantEstoque, 10),
            preco: parseFloat(precoProduto),
            descricao: descProduto,
            marca: marcaProd,
            nome: nomeProd,
            codSubcategoria: codSubcategoria
        };

        try {
            await produtoService.update(id, produtoAtualizado);
            console.log(`Produto com ID ${id} atualizado com sucesso!`);
            toast.success(`Produto com ID ${id} atualizado com sucesso!`);
            buscarProdutos();
        } catch (error) {
            console.error(`Erro ao atualizar produto com ID ${id}:`, error);
            toast.error(`Erro ao atualizar produto com ID ${id}:`, error);
        }
    }

    async function criarProduto() {
        if (!nomeProd || !marcaProd || !descProduto || !codSubcategoria || !precoProduto || !quantEstoque || !promocao || disponivel === null) {
            toast.error('Preencha todos os campos!');
            return;
        }

        if (parseInt(quantEstoque, 10) <= 0) {
            toast.error('Quantidade em estoque deve ser maior que zero!');
            return;
        }

        if (parseFloat(precoProduto) <= 0) {
            toast.error('Preço do produto deve ser maior que zero!');
            return;
        }
        const novoProduto = {
            codProduto: codProduto,
            dtCriacao: dataCriacao,
            disponivel: disponivel ? "true" : "false",
            promocao: promocao,
            qtdEstoque: parseInt(quantEstoque, 10),
            preco: parseFloat(precoProduto),
            descricao: descProduto,
            marca: marcaProd,
            nome: nomeProd,
            codSubcategoria: codSubcategoria
        };

        try {
            await produtoService.create(novoProduto);
            toast.success('Produto criado com sucesso!');
            // Limpe os campos do formulário
            setDataCriacao('');
            setDisponivel(null);
            setPromocao('');
            setQuantEstoque('');
            setPrecoProduto('');
            setDescProduto('');
            setMarcaProd('');
            setNomeProd('');
            setCodSubcategoria('');
            setCodProduto(''); // Limpa também o código do produto
            buscarProdutos(); // Atualiza a lista

        } catch (error) {
            console.error('Erro ao criar produto:', error);
            toast.error('Erro ao criar produto.', error);
        }
    }

    async function buscarProdutos() {
        try {
            const data = await produtoService.findAllProducts();
            setProdutos(data);
            setExibirProdutos(true); // Exibe os produtos
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
            toast.error('Erro ao buscar produtos:', error);
        }
    };

    async function deletarProdutoPorId(id) {
        if (!id) {
            toast.error('Digite um ID para deletar!');
            return;
        }

        try {
            await produtoService.deleteById(id);
            console.log(`Produto com ID ${id} deletado com sucesso.`);
            toast.success(`Produto com ID ${id} deletado com sucesso.`);
            buscarProdutos();
        } catch (error) {
            console.error(`Erro ao deletar produto com ID ${id}:`, error);
            toast.error(`Erro ao deletar produto com ID ${id}:`, error);
        }
    }

    return (
        <>
            <S.ContainerPai>
                <ToastContainer className='toastContainer' />
                <div className='divDashBoard'>
                    <img src={ImgLogo} />

                    <h1>DashBoard</h1>

                    <Link to={'/cadastrafuncionario'} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
                    <Link to={'/cadastroproduto'} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
                    <Link to={''} className='Link'><FaList className='icons' /> Categoria</Link>

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

                            <label>Nome</label>
                            <input className='InputNomeProd' type='text' value={nomeProd} onChange={e => setNomeProd(e.target.value)} />

                            <label>Marca</label>
                            <input className='InputMarcaProd' type='text' value={marcaProd} onChange={e => setMarcaProd(e.target.value)} />

                            <label htmlFor="descricao" >Descrição</label>
                            <textarea id="descricao" name="descricao" className='InputDescriProd' value={descProduto} onChange={e => setDescProduto(e.target.value)} />

                            <label htmlFor="CodCategoria">Codigo Sub-Categoria</label>
                            <input className='InputCodCategoria' type='text' value={codSubcategoria} onChange={e => setCodSubcategoria(e.target.value)} />
                        </section>

                        <section className='section2'>

                            <label className='LabelPrecoProd'>Preço</label>
                            <input className='InputPrecoProd' type='number' value={precoProduto} onChange={e => setPrecoProduto(e.target.value)} />

                            <label>Quantidade em Estoque</label>
                            <input className='InputQuantEsto' type='number' value={quantEstoque} onChange={e => setQuantEstoque(e.target.value)} />

                            <label >Em Promoção</label>
                            <input className='InputPromocao' type='text' value={promocao} onChange={e => setPromocao(e.target.value)} />

                        </section>


                        <section className='section2'>
                            <label className='LabelPrecoProd'>Disponivel</label>
                            <input className='InputDisponivel' type='text' value={disponivel} onChange={e => setDisponivel(e.target.value)} />

                            <label htmlFor="InputDataCriacao">Data de Criação</label>
                            <input className='InputDataCriacao' type='date' value={dataCriacao} onChange={e => setDataCriacao(e.target.value)} />

                            <label htmlFor="InputCodProduto">Codigo Produto</label>
                            <input className='InputCodProduto' type='text' value={codProduto} onChange={e => setCodProduto(e.target.value)} />

                        </section>
                    </div>

                    <section className='section3'>
                        <input type='number' placeholder='ID do Produto' value={idProduto} onChange={e => setIdProduto(e.target.value)} />

                        <button type='button' onClick={() => deletarProdutoPorId(idProduto)} >Deletar por ID</button>
                        <button type='button' onClick={() => atualizarProduto(idProduto)} >Atualizar por ID</button>
                        <button type='button' onClick={criarProduto}>Criar Produto</button>
                    </section>
                </div>
            </S.ContainerPai>
        </>
    );
}