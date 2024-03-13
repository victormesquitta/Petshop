import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import * as S from "./styles";
import ImgHomeTransition from "../../assets/images/ImgHomeTransition.png";
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

export function Home() {
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado />

                <S.DivMain>

                    <div className="DivImgTransition">
                        <img src={ImgHomeTransition} />

                        <h2>OS MELHORES PRODUTOS PARA CÃES</h2>
                    </div>

                    <div className="DivCards">
                        <section>
                            <img src={Card} />
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G
                                <p className="TextoRiscado">R$ 2,99</p>
                                <p>R$ 2,49</p>
                            </h3>
                        </section>
                        <section>
                            <img src={Card} />
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G
                                <p className="TextoRiscado">R$ 2,99</p>
                                <p>R$ 2,49</p>
                            </h3>
                        </section>
                        <section>
                            <img src={Card} />
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G
                                <p className="TextoRiscado">R$ 2,99</p>
                                <p>R$ 2,49</p>
                            </h3>
                        </section>
                        <section>
                            <img src={Card} />
                            <h3>DOG CHOW SACHÊ FRANGO MINI 100G
                                <p className="TextoRiscado">R$ 2,99</p>
                                <p>R$ 2,49</p>

                            </h3>
                        </section>

                    </div>
                    <p className="ParaPrincipaisMarcas"><strong className="PrincipaisMarcasTitulo">PRINCIPAIS MARCAS</strong></p>

                </S.DivMain>

                <S.ContainerMarcas>
                    <section>
                        <img src={ ImgPedigree } />
                        <img src={ ImgZeedog } />
                        <img src={ ImgNeD } />
                        <img src={ ImgPurina } />
                        <img src={ ImgPremieR } />
                        <img src={ ImgSuperSecao } />
                    </section>

                    <section className="SectionImgs">
                        <img src={ ImgRoyalCanin } />
                        <img src={ ImgPetSociety } />
                        <img src={ ImgWhiskas } />
                        <img src={ ImgFrontLine } />
                        <img src={ ImgFerplast } />
                        <img src={ ImgElanco } className="ImgElano"/>
                    </section>
                </S.ContainerMarcas>
            </S.ContainerPai>
        </>
    )
}