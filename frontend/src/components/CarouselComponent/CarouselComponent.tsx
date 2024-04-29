import ImgLogo from "../../assets/images/ImgLogo.svg";
import ImgCard from "../../assets/images/Card.png";
import * as S from './styles';
import { motion} from "framer-motion";
import { useState, useEffect, useRef } from 'react';
import { FaHeart, FaMedal } from "react-icons/fa";

const images = [ImgLogo, ImgCard, ImgLogo, ImgCard, ImgLogo, ImgCard, ImgLogo, ImgCard];

export function CarouselComponent() {
    const carousel = useRef<HTMLDivElement>(null);
    const [width, setWidth] = useState(0);
    const inner = useRef<HTMLDivElement>(null);

    useEffect(() => {
        if(inner.current) {
            setWidth(inner.current.scrollWidth - inner.current.offsetWidth);
        }
    }, [inner])

    return (
        <S.ContainerCarousel>
            <motion.div className='carousel' whileTap={{ cursor: "grabbing" }}>
                <motion.div className='inner' drag='x' ref={inner}
                    dragConstraints={{ left: -width, right: 0}}
                    initial={{ x: 100 }} animate={{ x: 0 }} transition={{ duration: 0.8 }}>

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

        </S.ContainerCarousel>
    );
}