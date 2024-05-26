import { FaUserAlt, FaObjectGroup, FaList, FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import * as S from './styles';


export function CadastroCategoria() {
    return (
        <>
            <S.ContainerPai>
                <div className='divDashBoard'>
                    <img src={ImgLogo} />

                    <h1>DashBoard</h1>

                    <Link to={''} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
                    <Link to={''} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
                    <Link to={''} className='Link'><FaList className='icons' /> Categoria</Link>
                    <Link to={''} className='Link'><FaList className='icons' /> SubCategoria</Link>
                    <Link to={'/adminpedidos'} className='Link'><FaShippingFast className='icons'/>Pedidos</Link>

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

                            <label >Imagem da Categoria</label>
                            <input className='InputImagemCat' />

                            <button className='CadastrarCategoria'>Cadastrar</button>

                        </section>

                    </div>
                </div>
            </S.ContainerPai>
        </>
    );
}