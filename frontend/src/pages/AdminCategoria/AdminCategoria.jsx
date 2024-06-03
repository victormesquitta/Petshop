import { FaSearch, FaArrowLeft } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import * as S from './styles';
import { useState } from 'react';
import { categoriaService } from '../../services/categoria.service';
import { toast, ToastContainer } from 'react-toastify'; // Importe o toast
import 'react-toastify/dist/ReactToastify.css'; // Importe o CSS do toast


export function AdminCategoria() {
    const navigate = useNavigate();

    const [nomeCategoria, setNomeCategoria] = useState('');
    const [destaqueCategoria, setDestaqueCategoria] = useState(false);
    const [descricaoCategoria, setDescricaoCategoria] = useState('');
    const [ativaCategoria, setAtivaCategoria] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();

        const novaCategoria = {
            nome: nomeCategoria,
            destaque: destaqueCategoria,
            descricao: descricaoCategoria,
            ativa: ativaCategoria,
        };

        try {
            await categoriaService.createCategoria(novaCategoria);
            toast.success('Categoria criada com sucesso!');
        } catch (error) {
            console.error('Erro ao criar categoria:', error);
            toast.error('Erro ao criar categoria. Verifique os dados e tente novamente.');
        }
    };
    return (
        <>
            <S.ContainerPai>
                <ToastContainer className='toastContainer' />
                <div className='divDashBoard'>
                    <img src={ImgLogo} />

                    <h1>DashBoard</h1>

                    <Link to={'/dashboardcategoria'} className='Link'><FaArrowLeft className='icons' />Voltar</Link>

                </div>

                <div className='divPrincipal'>
                    <section className='section1'>
                        <input placeholder='Pesquisar' className='InputPesquisar' />
                        <FaSearch className="IconLupa" />


                    </section>

                    <div>
                        <label>Nome:</label>
                        <input
                            type='text'
                            className='InputNomeCat'
                            value={nomeCategoria}
                            onChange={e => setNomeCategoria(e.target.value)}
                        />
                    </div>

                    <div>
                        <label>Destaque:</label>
                        <input
                            type='checkbox'
                            className='InputMarcaCat'
                            checked={destaqueCategoria}
                            onChange={e => setDestaqueCategoria(e.target.checked)}
                        />
                    </div>

                    <div>
                        <label htmlFor="descricao">Descrição:</label>
                        <textarea
                            id="descricao"
                            className='InputDescriCat'
                            value={descricaoCategoria}
                            onChange={e => setDescricaoCategoria(e.target.value)}
                        />
                    </div>

                    <div>
                        <label>Ativa:</label>
                        <input
                            type='checkbox'
                            className='InputImagemCat'
                            checked={ativaCategoria}
                            onChange={e => setAtivaCategoria(e.target.checked)}
                        />
                    </div>

                    <button className='CadastrarCategoria' onClick={handleSubmit}>
                        Cadastrar
                    </button>
                </div>
            </S.ContainerPai>
        </>
    );
}