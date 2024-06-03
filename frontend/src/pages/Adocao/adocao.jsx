import * as S from "./styles";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";

import labrador from "../../assets/images/labrador.jpg";
import beagle from "../../assets/images/beagle.jpg";
import poodle from "../../assets/images/poodle.jpg";
import ImgAdoptionBanner from "../../assets/images/ImgAdoptionBanner.png";
import adocao from "../../assets/images/adocao.jpg";
import adocao2 from "../../assets/images/adocao2.jpg";


export function Adocao(props) {
    const animals = [
        {
            id: 1,
            name: 'Rex',
            breed: 'Labrador',
            age: '2 anos',
            image: labrador
        },
        {
            id: 2,
            name: 'Mia',
            breed: 'Beagle',
            age: '1 ano',
            image: beagle
        },
        {
            id: 3,
            name: 'Bella',
            breed: 'Poodle',
            age: '3 anos',
            image: poodle
        }
    ];

    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 3,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1,
                    infinite: true,
                    dots: true
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }
        ]
    };


    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />

                <S.SectionTitle>
                    <h1>Adoção de Animais e Combate aos Maus-Tratos: Uma Jornada de Amor e Cuidado</h1>
                </S.SectionTitle>
                <S.Banner>
                    <img src={ImgAdoptionBanner} alt="Adote um Pet" />
                </S.Banner>

                <S.DivMain>
                    <S.TextSection>
                        <h2 className="linha">Por que Adotar?</h2>
                        <p>A adoção de animais é um ato de amor e responsabilidade que traz inúmeros benefícios. Ao adotar, você está salvando uma vida, ajudando a reduzir o número de animais abandonados e combatendo a superpopulação de pets. Além disso, os animais adotados tendem a ser extremamente gratos e leais. Eles sabem que você os resgatou e retribuem esse gesto com amor incondicional. Adotar também é uma maneira de dar o exemplo e inspirar outras pessoas a fazerem o mesmo, criando uma comunidade mais compassiva e solidária.</p>
                    </S.TextSection>

                    <S.TextSection>
                        <h2 className="linha">Confira nossos adoráveis pets</h2>
                    </S.TextSection>

                    <S.CarouselContainer>
                        <Slider {...settings}>
                            {animals.map(animal => (
                                <S.AnimalCard key={animal.id}>
                                    <img src={animal.image} alt={animal.name} />
                                    <h3>{animal.name}</h3>
                                    <p>Raça: {animal.breed}</p>
                                    <p>Idade: {animal.age}</p>
                                    <button>Adotar</button>
                                </S.AnimalCard>
                            ))}
                        </Slider>
                    </S.CarouselContainer>

                    <S.TextSection>
                        <h2 className="linha">Venha Conhecer nossa Ação</h2>
                        <p>Além disso, iniciativas como o perfil no Instagram <a href="https://www.instagram.com/mimuus_pet10/" target="_blank" rel="noreferrer">Mimu's Pet </a>
                            são exemplos inspiradores de como a plataforma pode ser usada para promover a adoção responsável e compartilhar histórias de amor e cuidado pelos animais. Ao seguir e apoiar páginas como essa, contribuímos para ampliar a conscientização sobre a importância de cuidar dos nossos amigos de quatro patas e oferecer-lhes um lar amoroso e seguro. Juntos, podemos fazer a diferença na vida desses seres especiais e criar uma comunidade online dedicada ao bem-estar animal.</p>

                        <S.Promotion>
                            <section className="promotion">
                                <img src={adocao} alt="Flyer de adoção" />
                                <img src={adocao2} />
                            </section>
                        </S.Promotion>
                    </S.TextSection>
                </S.DivMain>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    );
}
