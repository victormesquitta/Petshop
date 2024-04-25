import { useRef, useEffect, useState } from 'react';
import Card from '../../assets/images/Card.png';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { RodapeComponent } from '../../components/RodapeComponent/RodapeComponent';
import { AuthService } from '../../services/AuthService';
import * as S from './styles';
import { width } from '@fortawesome/free-regular-svg-icons/faAddressBook';
import { motion } from 'framer-motion';
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';

type MeusPedidosProps = {
    authService: AuthService;
}

const images = [Card, Card, Card, Card, Card, Card, Card, Card];

export function MeusPedidos(props: MeusPedidosProps) {

    const inner = useRef<HTMLDivElement>(null);
    const [width, setWidth] = useState(0);

    useEffect(() => {
        if (inner.current) {
            setWidth(inner.current.scrollWidth - inner.current.offsetWidth);
        }
    }, [inner])

    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />
                <S.ContainerMain>
                    <InformacoesComponent />
                    <div className='DivFavoritos'>
                        <h1 className='MeusPedidos'>Meus Pedidos</h1>
                        <h3 className='ConfiraPedidos'>Confira todos seus pedidos aqui</h3>

                        <motion.div className='divMeusPedidos' whileTap={{ cursor: "grabbing" }}>
                            <motion.div drag='y' ref={inner} dragConstraints={{ left: -width, right: 0 }}
                                initial={{ x: 100 }} animate={{ x: 0 }} transition={{ duration: 0.8 }}>
                                {images.map(image => (
                                    <motion.div className='item' key={image}>
                                        <img src={image} alt='Img não carregou' />
                                        <div>
                                            <h1>Pedido em andamento</h1>
                                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                        </div>
                                    </motion.div>
                                ))}
                            </motion.div>
                        </motion.div>
                    </div>
                </S.ContainerMain>
                <RodapeComponent />
            </S.ContainerPai >
        </>
    )
}