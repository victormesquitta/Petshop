import Card from '../../assets/images/Card.png';
import { FaHeart, FaMedal } from 'react-icons/fa';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { RodapeComponent } from '../../components/RodapeComponent/RodapeComponent';
import { AuthService } from '../../services/AuthService';
import * as S from './styles';

type MeusPedidosProps = {
    authService: AuthService;
}

export function MeusPedidos(props: MeusPedidosProps) {
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
                        <h1 className='MeusPedidos'>Meus Pedidos</h1>
                        <h3 className='ConfiraPedidos'>Confira todos seus pedidos aqui</h3>

                        <motion.div className='divMeusPedidos' whileTap={{ cursor: "grabbing" }}>
                            <motion.div  drag='x' ref={inner}   dragConstraints={{ left: -width, right: 0}}
                             initial={{ x: 100 }} animate={{ x: 0 }} transition={{ duration: 0.8 }}>
                                <section >
                                    <img src={Card} />
                                    <div>
                                        <h1>Pedido em andamento</h1>
                                        <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                    </div>
                                </section>

                                <section >
                                    <img src={Card} />
                                    <div>
                                        <h1>Pedido em andamento</h1>
                                        <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                    </div>
                                </section>
                            </motion.div>

                            <motion.div  drag='x' ref={inner}   dragConstraints={{ left: -width, right: 0}}
                             initial={{ x: 100 }} animate={{ x: 0 }} transition={{ duration: 0.8 }}>
                                <section >
                                    <img src={Card} />
                                    <div>
                                        <h1>Pedido em andamento</h1>
                                        <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                    </div>
                                </section>

                                <section >
                                    <img src={Card} />
                                    <div>
                                        <h1>Pedido em andamento</h1>
                                        <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                    </div>
                                </section>
                            </motion.div>

                    {images.map(image => (
                        <motion.div className='item' key={image}>
                            <img src={image} alt='Img não carregou' />
                            <p className="Pedigree">Pedigree <FaHeart className="IconCoracao" /></p>
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G</h3>
                            <p className="PrecoRiscado">R$ 2,99</p>
                            <p className="PrecoNormal">R$ 2,49</p>

                           {/*<p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>*/}
                            <button>Adicionar ao Carrinho</button>
                        </motion.div>
                    ))}
                </motion.div>
            </motion.div>

                        </div>
                    </div>
                </S.ContainerMain>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}