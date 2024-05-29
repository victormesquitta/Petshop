import { FaUserAlt, FaObjectGroup, FaList, FaSearch, FaShippingFast, FaArrowLeft } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import * as S from './styles';


export function AdminCategoria() {
    return (
        <>
            <S.ContainerPai>
                <div className='divDashBoard'>
                    <img src={ImgLogo} />

                    <h1>DashBoard</h1>

                    <Link to={'/'} className='Link'><FaArrowLeft className='icons' />Voltar</Link>

                </div>

                <div className='divPrincipal'>
                    <section className='section1'>
                        <input placeholder='Pesquisar' className='InputPesquisar' />
                        <FaSearch className="IconLupa" />

                        
                    </section>

                    <div>
                        <section className='section2'>
                            <h1>Nova Categoria</h1>

                            <label>Nome da Categoria</label>
                            <input className='InputNomeCat' />

                            <label>Destaque</label>
                            <input className='InputMarcaCat' />  
                        </section>

                        <section className='section2'>
                            <label htmlFor="descricao" >Descrição da Categoria</label>
                            <textarea id="descricao" name="descricao" className='InputDescriCat' />

                            <label>Ativa </label>
                            <input className='InputImagemCat' />
                            <button className='CadastrarCategoria'>Cadastrar</button>

                        </section>

                    </div>
                </div>
            </S.ContainerPai>
        </>
    );
}