import styled from "styled-components";

export const ContainerPai = styled.div`
  width: 100%;
  height: 100%;
`;

export const ContainerMain = styled.main`
display: flex;
  align-items: flex-start;
  padding: 4rem;
  height: auto;
  width: 100%;

  .DivFavoritos {
    width: 100%;

    display: flex;
    flex-direction: column;
    justify-content: center;

    margin-left: 5rem;

    height: 100%;

    div {
      display: flex;
    }

    h1 {
      color: #88ce08;

      font-size: 2vw;

      &:hover {
        text-decoration: underline;
      }
    }

    section {
      flex-direction: column;
      display: flex;
      align-items: center;
      justify-content: space-evenly;

      border: 1.5px solid;
      border-color: #88ce08;
      border-radius: 25px;

      width: 25%;
      height: 95%;

      padding: 2rem;
      padding-top: 1rem;
      padding-bottom: 1.4rem;

      margin-top: 1.5rem;
      margin-left: 3rem;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

      img {
        width: 70%;

        margin-top: .5rem;
      }

      h3 {
        margin-top: 0.5rem;
        padding-left: 0.7rem;

        font-size: 1vw;

        &:hover {
          text-decoration: underline;
          cursor: pointer;
        }
      }

      .IconCoracao {
        position: relative;
        left: 6rem;

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

        margin-top: 0.5rem;
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
        font-size: 1.3vw;
        font-weight: 800;
      }
      .MimuPoints {
        color: gold;
        font-size: 0.9vw;

        margin-top: 1rem;

        &:hover {
          text-decoration: underline;

          cursor: pointer;
        }
      }

      button {
        margin-top: 1rem;

        align-items: center;
        justify-content: center;

        font-size: .8vw;
        font-weight: 600;

        border: none;
        border-radius: 15px;
        border-color: #073950;

        width: 80%;
        height: 2rem;

        background-color: #073950;
        color: white;
      }
    }
  }
`;
