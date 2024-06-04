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
import ImageSlider from "../../components/ImageSlider/ImageSlider";
import Imgflyer from "../../assets/images/Imgflyer.jpg";
import ImgflyerTwo from "../../assets/images/ImgflyerTwo.jpg";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { produtoService } from "../../services/produto.service";
import { carrinhoService } from "../../services/itemCarrinho.service"; // Importar carrinhoService


export function Home(props) {
    const [produtos, setProdutos] = useState([]);

    useEffect(() => {
        // Buscar os produtos do banco de dados
        fetchProdutos();
    }, []);

    const fetchProdutos = async () => {
        try {
            const produtosData = await produtoService.findAllProducts(); // Obter os produtos do serviço
            setProdutos(produtosData.content.slice(0, 4));
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
            toast.error('Erro ao buscar produtos. Tente novamente mais tarde.');
        }
    };

    useEffect(() => {
        fetchProdutos();
        // Carregar o carrinho (se necessário)
        const carregarCarrinho = async () => {
          try {
            const dadosCarrinho = await carrinhoService.obterCarrinho();
            setCarrinho(dadosCarrinho); 
          } catch (error) {
            console.error('Erro ao carregar carrinho:', error);
          }
        };
        carregarCarrinho(); 
      }, []);
    
      const handleAdicionarAoCarrinho = async (produto) => {
        try {
          // 1. Adicionar o produto ao carrinho usando carrinhoService
          const resultado = await carrinhoService.adicionarProduto(produto.id, 1); // Ajuste o nome do campo ID 
    
          // 2. Atualizar o estado do carrinho
          setCarrinho(resultado); // Assumindo que o backend retorna o carrinho atualizado
    
          // 3. Exibir mensagem de sucesso (opcional)
          toast.success('Produto adicionado ao carrinho!');
        } catch (error) {
          console.error('Erro ao adicionar ao carrinho:', error);
          toast.error('Erro ao adicionar ao carrinho!');
        }
      };

    return (
        <>
            <S.ContainerPai>
                <ToastContainer/>
                < NavBarLogado authService={props.authService} />

                <S.DivMain>

                    <div className="DivImgTransition">
                        <ImageSlider />
                        <h2 className="linha">OS MELHORES PRODUTOS PARA CÃES</h2>
                    </div>

                    <div className="DivCards">
                        {Array.isArray(produtos) && produtos.map((produto, index) => ( // Renderizar cards dos produtos
                            <section key={index}>
                                <img src={Card} /> 
                                <p className="Pedigree">Pedigre <FaHeart className="IconCoracao" /></p> 
                                <h3>{produto.nome}</h3> 
                                <p className="PrecoRiscado">R$ {produto.preco}</p>
                                <p className="PrecoNormal">R$ {produto.preco}</p> 
                                <p className="MimuPoints"><FaMedal /> Ganhe 200 Mimu points com essa compra</p>
                                <button onClick={() => handleAdicionarAoCarrinho(produto)}>Adicionar ao Carrinho</button> 
                            </section>
                        ))}
                    </div>
                    <p className="linha ParaPrincipaisMarcas"><strong className="PrincipaisMarcasTitulo">PRINCIPAIS MARCAS</strong></p>

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
                <S.DivMain>
                    <h3 className="linha ParaPrincipaisMarcas"><strong className="PrincipaisMarcasTitulo">PROMOÇÃO</strong></h3>
                </S.DivMain>
                <S.Promotion>
                    <section className="promotion">
                        <Link to="/Adocao">
                            <img className="adote_one" src={Imgflyer} alt="Flyer de adoção" />
                        </Link>
                        <img className="adote_two" src={ImgflyerTwo} />
                    </section>
                </S.Promotion>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}