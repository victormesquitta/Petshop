import { FaTrash, FaUserAstronaut } from "react-icons/fa";
import * as S from "./styles";
import ImgLogo from "../../assets/images/ImgLogo.svg";
import ImgCard from "../../assets/images/Card.png";
import { FaTicket } from "react-icons/fa6";

export function Carrinho() {
    return (
        <>
            <S.ContainerPai>
                <S.NavBar>
                    <div>
                        <img src={ImgLogo} />

                        <button className="BotaoFimTela"><FaUserAstronaut className="IconAdmin" />Olá, João Gabriel</button>
                    </div>
                </S.NavBar>

                <S.ContainerMain>
                    <h1>Carrinho de compras</h1>

                    <div className="DivCarrinhoLixo">
                        <h3>Produtos</h3>
                        <h3> Limpar carrinho</h3>
                    </div>

                    <div className="DivProdutos">
                        <section className="SecInfoProduto">
                            <img src={ImgCard} className="ImgCard" />
                            <p className="Titulo">Petisco Cookie Cães Origem Natural Fit com Banana 250g</p>
                            <input type="number" placeholder="0" />
                            <p> <FaTrash className="IconLixo" />R$ 29,99</p>

                        </section>

                        <section className="SecInfoPrecos">
                            <div>
                                <p>Produtos</p>
                                <p>R$ 29,99</p>
                            </div>

                            <div>
                                <p>Total</p>
                                <p>R$ 29,99</p>
                            </div>

                            <div className="DivBotoes">
                                <button>Finalizar Pedido</button>
                                <button>Continuar Comprando</button>
                            </div>
                        </section>
                    </div>

                    <div className="DivFretePrazo">
                        <h3>Frete e Prazo</h3>
                        <h3>Cupom de desconto <FaTicket className="TicketIcon"/></h3>
                    </div>

                    <div className="DivCupomFrete">
                        <section>
                            <input type="text" placeholder="CEP" />
                            <button className="BotaoCep">Buscar</button>
                        </section>

                        <section>
                            <input type="text" placeholder="Insira seu cupom" />
                            <button className="CupomDesconto">Aplicar </button>
                        </section>   
                    </div> 
                    <h3 className="TituloPodeInteressar">Também pode te interessar</h3>
                </S.ContainerMain>
            </S.ContainerPai>
        </>
    );
}