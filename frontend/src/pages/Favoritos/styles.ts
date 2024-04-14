import styled from "styled-components";

export const ContainerPai = styled.div`
  width: 100%;
  height: 100%;
`;

export const ContainerMain = styled.main`
  display: flex;
  align-items: center;

  margin-left: 2rem;
  margin-top: 2rem;
  margin-bottom: 2rem;

  height: 90%;

  .DivFavoritos {
    width: 100%;

    display: flex;
    flex-direction: column;
    justify-content: center;

    margin-left: 5rem;

    div {
      display: flex;
    }

    h1{
        color: lightgreen;

        font-size: 2vw;
    }

    section {
      flex-direction: column;
      display: flex;
      align-items: center;
      justify-content: space-evenly;

      border: 1.5px solid;
      border-color: lightgray;
      border-radius: 25px;

      width: 25%;

      padding: 2rem;
      margin-top: 1.5rem;
      margin-left: 3rem;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

      img {
        width: 80%;
      }

      h3 {
        margin-top: 0.5rem;
        padding-left: 0.7rem;

        font-size: 1vw;
      }

      .IconCoracao {
        position: relative;
        left: 7rem;

        color: red;

        width: 20%;
        height: 1.3rem;

        margin-top: 0.5rem;

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

  .SectionInformacoes {
    display: flex;
    flex-direction: column;
    align-items: start;
    justify-content: start;

    border: 1.5px solid;
    border-color: lightgreen;
    border-radius: 15px;

    width: 22%;

    padding: 2rem;

    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

    height: 80%;

    h1 {
      margin-bottom: 1rem;

      color: lightgreen;
    }

    p {
      margin-top: 1rem;

      color: lightgreen;
    }
  }
`;
