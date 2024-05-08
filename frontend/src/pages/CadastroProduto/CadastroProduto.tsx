import { FaUserAlt, FaObjectGroup, FaList, FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilDog from '../../assets/images/ImgPerfilDog.png';
import * as S from './styles';

export function CadastroProduto() {
    return (
        <>
            <S.ContainerPai>
                <div className='divDashBoard'>
                    <img src={ImgLogo} />

                    <h1>DashBoard</h1>

                    <Link to={''} className='Link'><FaUserAlt className='icons' />Funcionario</Link>
                    <Link to={''} className='Link'><FaObjectGroup className='icons' /> Produtos</Link>
                    <Link to={''} className='Link'><FaList className='icons' /> Categoria</Link>

                </div>

                <div className='divPrincipal'>
                    <section className='section1'>
                        <input placeholder='Pesquisar' className='InputPesquisar' />
                        <FaSearch className="IconLupa" />

                        <img src={ImgPerfilDog} />
                    </section>

                    <div>
                        <section className='section2'>
                            <h1>Novo Produto</h1>

                            <label>Marca do Produto</label>
                            <input className='InputNomeProd' />

                            <label>Marca do Produto</label>
                            <input className='InputMarcaProd' />

                            <label htmlFor="descricao" >Descrição do Produto</label>
                            <textarea id="descricao" name="descricao" className='InputDescriProd' />
                        </section>



                        <section className='section2'>

                            <label className='LabelPrecoProd'>Preço do Produto</label>
                            <input className='InputPrecoProd' />

                            <label>Quantidade de Estoque</label>
                            <input className='InputQuantEsto' />

                            <label >Imagem do Produto</label>
                            <input className='InputImagemProd' />

                        </section>

                    </div>
                </div>
            </S.ContainerPai>
        </>
    );
}