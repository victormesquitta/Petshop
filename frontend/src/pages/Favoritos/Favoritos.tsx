import Card from '../../assets/images/Card.png';
import { FaHeart, FaMedal } from 'react-icons/fa';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { RodapeComponent } from '../../components/RodapeComponent/RodapeComponent';
import { AuthService } from '../../services/AuthService';
import * as S from './styles';

type FavoritosProps = {
    authService: AuthService;
}

export function Favoritos(props: FavoritosProps) {
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />
                <S.ContainerMain>
                    <section className='SectionInformacoes'>
                        <h1>Olá Victor</h1>

                        <p>Dados Pessoais</p>
                        <p>Meus Pedidos</p>
                        <p>Favoritos</p>
                        <p>Meus Cartões</p>
                        <p>Meus Pets</p>
                    </section>

                    <div className='DivFavoritos'>
                        <h1>Favoritos</h1>

                        <div>
                            <section >
                                <img src={Card} />
                                <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p>
                                <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                <p className="PrecoRiscado">R$ 2,99</p>
                                <p className="PrecoNormal">R$ 2,49</p>

                                <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                                <button>Adicionar ao Carrinho</button>

                            </section>

                            <section >
                                <img src={Card} />
                                <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p>
                                <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                <p className="PrecoRiscado">R$ 2,99</p>
                                <p className="PrecoNormal">R$ 2,49</p>

                                <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                                <button>Adicionar ao Carrinho</button>

                            </section>
                        </div>
                    </div>
                </S.ContainerMain>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}