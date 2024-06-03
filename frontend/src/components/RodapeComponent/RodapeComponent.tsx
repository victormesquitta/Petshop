import * as S from "./styles";
import React, { useState } from 'react';
import { FaFacebookSquare, FaInstagram, FaWhatsapp } from "react-icons/fa";
import ImgLogo from "../../assets/images/ImgLogo.svg";
import GoogleNavegacaoSegura from "../../assets/images/GoogleNavegacaoSegura.png";
import GoogleSafeBrowsing from "../../assets/images/GoogleSafeBrowsing.png"
import PremioEpoca from "../../assets/images/PremioEpoca.png";
import { Link } from "react-router-dom";

export function RodapeComponent() {
    const [isOpen, setIsOpen] = useState(false);

    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    };

    return (
        <>
            <S.ContainerPai>
                <S.ContainerNav>
                    <div>
                        <p>Receba ofertas</p>
                        <h3><strong>Excluisvas</strong></h3>
                        <p>para você.</p>
                    </div>

                    <input type="email" placeholder="Digite seu email" className="InputEmail" />

                    <div className="Dropdown">
                        <button onClick={toggleDropdown} className="BotaoSeuPet">Seu Pet</button>
                        {isOpen && (
                            <ul className="dropdown-menu">
                                <li>Opção 1</li>
                                <li>Opção 2</li>
                                <li>Opção 3</li>
                            </ul>
                        )}
                    </div>
                    <button className="Cadastrar"> <Link to={"RegistrarConta"} className="Link">Cadastrar</Link></button>
                </S.ContainerNav>

                <S.ContainerInformacoesSite>
                    <div className="DivInformacoes">
                        <div>
                            <h3>Institucional</h3>
                            <p>Quem Somos</p>
                            <p>Trabalhe Conosco</p>
                            <p>Politicas de entregas</p>
                            <p>Politicas de Privacidade</p>
                            <p>Formas d Pagamnto</p>
                        </div>
                        <div>
                            <h3 className="FaleConosco">Fale Conosco</h3>
                            <p>(11) 5858-8383</p>
                            <p>(11) 92923-9292</p>
                            <p className="SacMimu">sac@mimuspet.com.br</p>
                            <p>Av. Eng. Eusebio Stevaux,</p>
                            <p>823 - Santo Amaro, São Paulo</p>
                        </div>
                        <div>
                            <h3 className="SelosCertificados">Selos e Certificados</h3>
                            <img src={GoogleSafeBrowsing} className="GoogleSafeBrowsing" />
                            <img src={GoogleNavegacaoSegura} className="GoogleNavegacaoSegura" />
                        </div>

                        <img src={PremioEpoca} className="ImgPremioEpoca" />
                        <Link to="/">
                            <img src={ImgLogo} alt="Logo" />
                        </Link>
                    </div>

                    <div className="DivRedesSociais">
                        <h3>Redes Sociais</h3>
                        <div className="RedesSociais">
                            <FaWhatsapp className="ImgWhatsapp" />
                            {/* <a href="https://www.instagram.com/mimuus_pet10?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw==" target="_blank" rel="noopener noreferrer" className="ImgInstagramLink"> */}
                            <FaInstagram className="ImgInstagram" />
                            {/* </a> */}
                            <FaFacebookSquare className="ImgFacebook" />
                        </div>
                    </div>
                </S.ContainerInformacoesSite>

                <section className="Copyright">
                    <p>&copy;Todos os direitos reservados a Companhia Mimu's Pets 2024</p>
                </section>
            </S.ContainerPai>
        </>
    )
}