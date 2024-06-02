import { useRef, useEffect, useState } from 'react';
import Card from '../../assets/images/Card.png';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { RodapeComponent } from '../../components/RodapeComponent/RodapeComponent';
import { AuthService } from '../../services/AuthService';
import * as S from './styles';
import { motion } from 'framer-motion';
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';


export function MeusPedidos(props) {
    const carousel = useRef(null);
    const [pedidos, setPedidos] = useState([]); // Estado para os pedidos

    useEffect(() => {
        // Função para buscar os pedidos do usuário autenticado
        const buscarPedidosDoUsuario = async () => {
            try {
                // Recupere o ID do usuário autenticado (ajuste conforme necessário)
                const usuarioId = props.authService.getUsuarioLogado()?.id; 

                if (usuarioId) {
                    const data = await pedidoService.findPedidoById(usuarioId); 
                    setPedidos(data); // Atualize o estado com os pedidos
                } else {
                    // Lide com o caso do usuário não estar autenticado
                    console.error("Usuário não autenticado.");
                }
            } catch (error) {
                console.error('Erro ao buscar pedidos:', error);
            }
        };

        buscarPedidosDoUsuario(); 
    }, []);

    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />
                <S.ContainerMain>
                    <InformacoesComponent />
                    <div className='DivFavoritos'>
                        <h1 className='MeusPedidos'>Meus Pedidos</h1>
                        <h3 className='ConfiraPedidos'>Confira todos seus pedidos aqui</h3>

                        <motion.div className='divMeusPedidos' ref={carousel}>
                            <motion.div className="carousel" whileTap={{ cursor: "grab" }}>
                                <motion.div
                                    className='inner'
                                    drag="x"
                                    dragConstraints={{ left: 0, right: 0 }}
                                >
                                    {pedidos.map((pedido) => (
                                        <motion.div className='item' key={pedido.codPedido}>
                                            <img src={''} alt='Img não carregou' />
                                            <div>
                                                <h1>{pedido.status}</h1>
                                                <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                                            </div>
                                        </motion.div>
                                    ))}
                                </motion.div>
                            </motion.div>
                        </motion.div>
                    </div>
                </S.ContainerMain>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}