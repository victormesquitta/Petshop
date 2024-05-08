import * as S from './styles';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import ImgPerfilFuncionario from '../../assets/images/ImgPerfilFuncionario.png';
import { Link } from 'react-router-dom';
import { FaList, FaObjectGroup, FaSearch, FaUserAlt } from 'react-icons/fa';

export function CadastraFuncionario() {
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

                        <img src={ImgPerfilFuncionario} />
                    </section>

                    <section className='section2'>
                        <h1>Novo Funcionário</h1>

                        <label>Nome Completo</label>
                        <input className='InputNomeFun' />

                        <label>Registro Funcionario</label>
                        <input className='InputRegistroFun' />
                    </section>

                </div>
            </S.ContainerPai>
        </>
    );
}