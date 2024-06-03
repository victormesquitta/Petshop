import { FaPlusCircle } from 'react-icons/fa';
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { AuthService } from '../../services/AuthService';
import ImgPerfilDog from '../../assets/images/ImgPerfilDog.png'
import * as S from './styles';
import { FaEllipsisVertical } from 'react-icons/fa6';


export function MeusPets(props) {
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />

                <S.ContainerMain>
                    <InformacoesComponent />

                    <div className='divMain'>
                        <div className='meusPets'>
                            <h1>Meus Pets</h1>

                            <button className='cadastrar'>Cadastrar novo pet</button>
                        </div>

                        <div className='divInformacoes'>
                            <section className='sectionInfosPet'>
                                <img className='ImgCachorro' src={ImgPerfilDog} />

                                <div>
                                    <h3>Milla</h3>
                                    <p>Shitzu</p>
                                    <p>10 anos</p>
                                </div>

                                <FaEllipsisVertical className='iconReticencias'/>

                            </section>

                            {/* <FaPlusCircle className='CirculoMais'/> */}
                        </div>
                    </div>

                </S.ContainerMain>
            </S.ContainerPai>
        </>
    )
}