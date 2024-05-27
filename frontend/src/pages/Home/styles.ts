import styled from "styled-components";

export const ContainerPai = styled.div`
  * {
    font-size: 1vw;
    font-family: "Roboto", sans-serif;
  }

  width: 100%;
  height: 100%;
`;

export const Promotion = styled.section`
  display: flex;
  flex-direction: column;
  align-items: center;  // Alinha os itens ao centro horizontalmente
  justify-content: center;  // Alinha os itens ao centro verticalmente
  text-align: center;  // Garante que o texto também fique centralizado

  .promotion {
    width: 100%;  // Ocupa toda a largura do container pai
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    gap: 10em;
    margin-bottom:2.5rem;

    img {
      max-width: 100%;  // Assegura que a imagem não exceda a largura do container
      height: 50vh;  // Mantém a proporção da imagem
    }
  }
`;

export const DivMain = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;

  .DivImgTransition {
    margin-top: 3rem;
    width: 50%;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 3.5rem;

    img {
      width: 60%;
      background-color: white;
    }

    h2 {
      font-size: 1.4vw;
      letter-spacing: 0.1rem;
    }
  }

  .DivCards {
    width: 90%;
    margin-bottom: 2rem;
    display: flex;
    align-items: center;
    justify-content: space-around;

    section {
      flex-direction: column;
      display: flex;
      align-items: center;
      justify-content: space-evenly;
      border: 1.5px solid lightgray;
      border-radius: 25px;
      width: 22%;
      height: 30rem;
      padding: 2rem;
      margin-top: 3.5rem;
      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

      p:hover {
        text-decoration: underline;
      }

      img {
        width: 80%;
        height: 11rem;
      }

      h3 {
        margin-top: 0.5rem;
        padding-left: 0.7rem;
        font-size: 1vw;

        &:hover {
          text-decoration: underline;
        }
      }

      .IconCoracao {
        position: relative;
        left: 7rem;
        color: red;
        width: 20%;
        height: 1.3rem;
        cursor: pointer;
      }
      .Pedigree {
        font-size: 0.9vw;
        color: lightslategray;
        width: 100%;
        align-items: start;
        margin-top: 0.7rem;
      }
      .PrecoRiscado {
        text-decoration: line-through;
        font-size: 0.8vw;
        color: lightslategray;
        margin-top: 1rem;
        position: relative;
        right: 2rem;
      }
      .PrecoNormal {
        font-size: 1.5vw;
        font-weight: 800;
      }
      .MimuPoints {
        color: gold;
        font-size: 0.9vw;
        margin-top: 1rem;
      }

      button {
        margin-top: 1rem;
        align-items: center;
        justify-content: center;
        font-weight: 600;
        border: none;
        border-radius: 15px;
        border-color: #073950;
        width: 80%;
        height: 2.2rem;
        background-color: #073950;
        color: white;
      }
    }
  }
  .linha {
    font-size: 1.4vw;
    text-align: center;
    color: black;  // Cor do texto

    &::after {
      content: "";
      display: block;
      width: 50%;  
      height: 0.3em;
      background-color: #88ce08;  
      margin: 0 auto;
      margin-top: .5em;  
    }
  }
  .ParaPrincipaisMarcas {
    margin-top: 2.5rem;
    margin-bottom: 3rem;

    .PrincipaisMarcasTitulo {
      font-size: 1.4vw;
      letter-spacing: 0.1rem;
    }
  }

  @media (max-width: 1024px) {
    .DivImgTransition h2 {
      font-size: 2.5vw;
    }

    .DivCards section {
      height: 20rem;

      img {
        width: 60%;
      }

      h3 {
        font-size: 1.3vw;
      }

      .IconCoracao {
        left: 5.5rem;
      }

      p {
        font-size: 1vw;
      }
    }
  }
`;

export const ContainerMarcas = styled.section`
  flex-direction: column;
  padding-top: 1.5rem;
  padding-bottom: 1.5rem;
  background-color: #88ce08;

  section {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    width: 100%;

    img {
      width: 10%;
    }
  }
  .SectionImgs {
    img {
      margin-top: 1rem;
    }

    .ImgElano {
      background-color: white;
      height: 8.4rem;
    }
  }
`;

