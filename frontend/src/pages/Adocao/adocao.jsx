import * as S from "./styles";
import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";
import labrador from "../../assets/images/labrador.jpg";
import beagle from "../../assets/images/beagle.jpg";
import poodle from "../../assets/images/poodle.jpg";



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

    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />

                <S.DivMain>
                    <S.Banner>
                        {/* <img src={ImgAdoptionBanner} alt="Adote um Pet" /> */}
                    </S.Banner>
                    <S.SectionTitle>
                        <h1>Adote um Amigo</h1>
                        {/* <p>Esses animais indefesos enfrentam uma jornada difícil, vivendo nas ruas, sofrendo com a fome, doenças e a solidão. É aí que a adoção responsável entra em ação. Ao adotar um animal, você não apenas dá a ele uma segunda chance de ter uma vida feliz e segura, mas também está contribuindo para o resgate de um ser vulnerável.</p> */}
                        <p>Veja abaixo os pets disponíveis para adoção e encontre um novo amigo para a vida toda.</p>
                    </S.SectionTitle>

                    <S.AnimalsContainer>
                        {animals.map(animal => (
                            <S.AnimalCard key={animal.id}>
                                <img src={animal.image} alt={animal.name} />
                                <h3>{animal.name}</h3>
                                <p>Raça: {animal.breed}</p>
                                <p>Idade: {animal.age}</p>
                                <button>Adotar</button>
                            </S.AnimalCard>
                        ))}
                    </S.AnimalsContainer>
                </S.DivMain>

                <RodapeComponent />
            </S.ContainerPai>
        </>
    );
}