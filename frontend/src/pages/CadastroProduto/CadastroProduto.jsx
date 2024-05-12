import { FaUserAlt, FaObjectGroup, FaList, FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilDog from '../../assets/images/ImgPerfilDog.png';
import * as S from './styles';
import { useState } from 'react';
import { produtoService } from '../../services/produto.service';

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
    const [mensagem, setMensagem] = useState(null);


    async function atualizarProduto(id) {
        const produtoAtualizado = {
            codProduto: id,
            dtCriacao: dataCriacao,
            disponivel: disponivel ? "true" : "false",  // Converte para "true" ou "false" (string)
            promocao: promocao,
            qtdEstoque: parseInt(quantEstoque, 10), // Converte para número
            preco: parseFloat(precoProduto), // Converte para número
            descricao: descProduto,
            marca: marcaProd,
            nome: nomeProd
        };

        try {
            await produtoService.update(id, produtoAtualizado);
            console.log('Produto atualizado com sucesso!');
            setMensagem('Produto atualizado com sucesso!'); // Define a mensagem de sucesso

            buscarProdutos(); // Atualiza a lista
        } catch (error) {
            console.error('Erro ao atualizar produto:', error);
            setMensagem('Erro ao atualizar produto!'); // Define a mensagem de sucesso

        }
    }

    async function criarProduto() {
        const novoProduto = {
            codProduto: 0, // ou outro valor inicial apropriado
            dtCriacao: dataCriacao,
            disponivel: disponivel ? "true" : "false",
            promocao: promocao,
            qtdEstoque: parseInt(quantEstoque, 10),
            preco: parseFloat(precoProduto),
            descricao: descProduto,
            marca: marcaProd,
            nome: nomeProd
        };

        try {
            await produtoService.create(novoProduto);
            setMensagem('Produto criado com sucesso!');
            // Limpe os campos do formulário
            setDataCriacao('');
            setDisponivel(null);
            // ... limpe outros estados ...
            buscarProdutos(); // Atualiza a lista
        } catch (error) {
            console.error('Erro ao criar produto:', error);
            setMensagem('Erro ao criar produto.');
        }
    }

    async function buscarProdutos() {
        try {
            const data = await produtoService.findAllProducts();
            setProdutos(data);
            setExibirProdutos(true); // Exibe os produtos
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
        }
    };

    async function deletarProdutoPorId(id) {
        try {
            await produtoService.deleteById(id);
            console.log(`Produto com ID ${id} deletado com sucesso.`);
            // Atualize a lista de produtos ou faça outra ação necessária
        } catch (error) {
            console.error(`Erro ao deletar produto com ID ${id}:`, error);
            // Trate o erro adequadamente
        }

        buscarProdutos();
    }

    return (
        <>
            <S.ContainerPai>
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

                    {mensagem && (
                        <div className="mensagem"> {/* Adicione uma classe para estilizar a mensagem */}
                            {mensagem}
                        </div>
                    )}
                    <div>
                        <section className='section2'>
                            <h1>Novo Produto</h1>

                            <label>Nome do Produto</label>
                            <input className='InputNomeProd' type='text' value={nomeProd} onChange={e => setNomeProd(e.target.value)} />

                            <label>Marca do Produto</label>
                            <input className='InputMarcaProd' type='text' value={marcaProd} onChange={e => setMarcaProd(e.target.value)} />

                            <label htmlFor="descricao" >Descrição do Produto</label>
                            <textarea id="descricao" name="descricao" className='InputDescriProd' value={descProduto} onChange={e => setDescProduto(e.target.value)} />
                        </section>



                        <section className='section2'>

                            <label className='LabelPrecoProd'>Preço do Produto</label>
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

                        </section>

                        <input type='number' placeholder='ID do Produto' value={idProduto} onChange={e => setIdProduto(e.target.value)} />

                        <button type='button' onClick={() => deletarProdutoPorId(idProduto)} >Deletar por ID</button>
                        <button type='button' onClick={() => atualizarProduto(idProduto)} >Atualizar por ID</button>
                        <button type='button' onClick={criarProduto}>Criar Produto</button>


                    </div>
                </div>
            </S.ContainerPai>
        </>
    );
}