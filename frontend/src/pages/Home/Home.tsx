import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import * as S from "./styles";
import ImgHomeTransition1 from "../../assets/images/ImgHomeTransition1.png";
import ImgHomeTransition2 from "../../assets/images/ImgHomeTransition2.png";
import Card from "../../assets/images/Card.png";
import ImgPedigree from "../../assets/images/ImgPedigree.png";
import ImgZeedog from "../../assets/images/ImgZeedog.png";
import ImgNeD from "../../assets/images/ImgNeD.png";
import ImgPurina from "../../assets/images/ImgPurina.png";
import ImgPremieR from "../../assets/images/ImgPremieR.png";
import ImgSuperSecao from "../../assets/images/ImgSuperSecao.png";
import ImgElanco from "../../assets/images/ImgElanco.png";
import ImgFerplast from "../../assets/images/ImgFerplast.png";
import ImgFrontLine from "../../assets/images/ImgFrontLine.png";
import ImgWhiskas from "../../assets/images/ImgWhiskas.png";
import ImgPetSociety from "../../assets/images/ImgPetSociety.png";
import ImgRoyalCanin from "../../assets/images/ImgRoyalCanin.png";
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";
import { FaHeart, FaMedal } from "react-icons/fa";
import { AuthService } from "../../services/AuthService";
import ImageSlider from "../../components/ImageSlider/ImageSlider";

type HomeProps = {
    authService: AuthService;
}

export function Home(props: HomeProps) {
 
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />

                <S.DivMain>

                    <div className="DivImgTransition">
                    <ImageSlider />
                        <h2>OS MELHORES PRODUTOS PARA CÃES</h2>
                    </div>

                    <div className="DivCards">
                        <section>
                            <img src={Card} />
                            <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p>
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G</h3>
                            <p className="PrecoRiscado">R$ 2,99</p>
                            <p className="PrecoNormal">R$ 2,49</p>

                            <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                            <button>Adicionar ao Carrinho</button>

                        </section>
                        <section>
                            <img src={Card} />
                            <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p>
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G</h3>
                            <p className="PrecoRiscado">R$ 2,99</p>
                            <p className="PrecoNormal">R$ 2,49</p>

                            <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                            <button>Adicionar ao Carrinho</button>

                        </section>
                        <section>
                            <img src={Card} />
                            <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p>
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                            <p className="PrecoRiscado">R$ 2,99</p>
                            <p className="PrecoNormal">R$ 2,49</p>

                            <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                            <button>Adicionar ao Carrinho</button>

                        </section>
                        <section>
                            <img src={Card} />
                            <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p>
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G </h3>
                            <p className="PrecoRiscado">R$ 2,99</p>
                            <p className="PrecoNormal">R$ 2,49</p>

                            <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                            <button>Adicionar ao Carrinho</button>

                        </section>

                    </div>
                    <p className="ParaPrincipaisMarcas"><strong className="PrincipaisMarcasTitulo">PRINCIPAIS MARCAS</strong></p>

                </S.DivMain>

                <S.ContainerMarcas>
                    <section>
                        <img src={ImgPedigree} />
                        <img src={ImgZeedog} />
                        <img src={ImgNeD} />
                        <img src={ImgPurina} />
                        <img src={ImgPremieR} />
                        <img src={ImgSuperSecao} />
                    </section>

                    <section className="SectionImgs">
                        <img src={ImgRoyalCanin} />
                        <img src={ImgPetSociety} />
                        <img src={ImgWhiskas} />
                        <img src={ImgFrontLine} />
                        <img src={ImgFerplast} />
                        <img src={ImgElanco} className="ImgElano" />
                    </section>
                </S.ContainerMarcas>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}