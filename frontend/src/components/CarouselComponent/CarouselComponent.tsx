import ImgLogo from "../../assets/images/ImgLogo.svg";
import ImgCard from "../../assets/images/Card.png";
import * as S from './styles';
import { motion } from "framer-motion";
import { useState, useEffect, useRef } from 'react';
import { FaHeart } from "react-icons/fa";
import { produtoService } from '../../services/produto.service'; 

export function CarouselComponent() {
    const carousel = useRef<HTMLDivElement>(null);
    const [width, setWidth] = useState(0);
    const inner = useRef<HTMLDivElement>(null);
    const [produtos, setProdutos] = useState([]); // Estado para os produtos

    useEffect(() => {
        fetchProdutos();
    }, []);
    
    const fetchProdutos = async () => {
        try {
            const produtosData = await produtoService.findAllProducts(); // Busca do backend
            setProdutos(produtosData.content); 
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
        }
    };

    useEffect(() => {
        if (inner.current) {
            setWidth(inner.current.scrollWidth - inner.current.offsetWidth);
        }
    }, [inner])

    return (
        <S.ContainerCarousel>
            <motion.div className='carousel' whileTap={{ cursor: "grabbing" }}>
                <motion.div className='inner' drag='x' ref={inner}
                    dragConstraints={{ left: -width, right: 0 }}
                    initial={{ x: 100 }} animate={{ x: 0 }} transition={{ duration: 0.8 }}>

                    {produtos.slice(0, 10).map((produto, index) => (
                        <motion.div className='item' key={index}>
                            <img src={ImgCard} alt='Img não carregou' /> {/* Use 'ImgCard' como placeholder */}
                            <p className="Pedigree">Pedigree <FaHeart className="IconCoracao" /></p>
                            <h3>{produto.nome}</h3>
                            <p className="PrecoRiscado">R$ {produto.preco}</p>
                            <p className="PrecoNormal">R$ {produto.preco}</p>

                            <button>Adicionar ao Carrinho</button>
                        </motion.div>
                    ))}
                </motion.div>
            </motion.div>

        </S.ContainerCarousel>
    );
}