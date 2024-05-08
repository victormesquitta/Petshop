import styled from "styled-components";

export const ContainerPai = styled.div`
  width: 100%;
  height: 100%;

  .CompreTambem {
    margin-top: 5rem;
    margin-bottom: 2rem;
    padding-left: 7rem;

    font-size: 1.5vw;
  }
`;

export const ContainerMain = styled.div`
  width: 100%;
  height: 23rem;

  display: flex;
  align-items: center;
  justify-content: space-evenly;

  img {
    height: 13rem;
    width: 15%;

    margin-left: 4rem;

    cursor: pointer;
  }
  .InfoProduto {
    display: flex;
    align-items: start;
    justify-content: center;
    flex-direction: column;

    width: 40%;

    cursor: pointer;

    h2 {
      margin-top: 1rem;
    }

    p {
      margin-top: 1.5rem;
    }

    .IconEstrelas {
      color: gold;

      text-decoration: underline;
    }
  }

  section {
    border: 1px solid;
    border-radius: 15px;
    border-color: lightgray;

    margin-top: 5.5rem;

    width: 25%;
    height: 18rem;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    gap: 0.5rem;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

    div {
      display: flex;
      flex-direction: column;
      align-items: start;
      justify-content: center;

      width: 100%;

      padding-left: 2rem;

      gap: 0.5rem;

      h2 {
        margin-top: 0.4rem;

        font-size: 1.6vw;

        line-height: 1.5rem;
      }

      .PrecoRiscado {
        text-decoration: line-through;
        font-size: 1.2vw;
      }

      input {
        width: 13%;
        height: 2rem;

        padding-left: 0.7rem;

        border-radius: 10px;
        border: 1px solid;

        position: relative;

        bottom: 2rem;
        left: 10rem;

        color: lightgray;
      }

      p {
        font-size: 1.1vw;
      }
      .ParaAVista {
        margin-top: -1.7rem;
      }
      .ParaEconomia {
        color: green;

        margin-bottom: 1rem;
      }
    }

    button {
      border: 1px solid;
      border-radius: 10px;

      width: 60%;
      height: 2rem;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    }

    .BotaoCarrinho {
      color: white;
      background-color: #073950;
      border: none;

      margin-top: 0.7rem;
    }

    .BotaoComprar {
      color: #073950;
      background-color: white;
      border-color: #073950;
    }
  }
`;
