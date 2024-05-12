import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import * as S from "./styles";
import ImgCard from "../../assets/images/Card.png";
import { FaStar, FaStarHalf } from "react-icons/fa";
import { FaStarHalfStroke } from "react-icons/fa6";
import { CarouselComponent } from "../../components/CarouselComponent/CarouselComponent";
import { AuthService } from "../../services/AuthService";


export function Produto(props) {
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />
                <S.ContainerMain>
                    <img src={ImgCard} />

                    <div className="InfoProduto">
                        <h3>Cookie</h3>

                        <h2>Petisco Cookie Cães Origem Natural Fit com Banana 250g</h2>

                        <p className="IconEstrelas">4.5 <FaStar className=""/> <FaStar /> <FaStar /> <FaStar /> <FaStarHalfStroke />  (100 opniões)</p>
                    </div>

                    <section>
                        <div>
                            <h2 className="PrecoRiscado">R$ 39,99</h2>
                            <h2>R$ 29,99</h2>
                            <input type="number" placeholder="0" />

                            <p className="ParaAVista">À Vista</p>
                            <p className="ParaEconomia">Economia de 25,64%</p>
                        </div>

                        <button className="BotaoCarrinho">Adicione ao Carrinho</button>
                        <button className="BotaoComprar">Comprar Agora</button>
                    </section>

                </S.ContainerMain>

                <h2 className="CompreTambem">Compre também</h2>
                <CarouselComponent/>
            </S.ContainerPai>
        </>
    );
}