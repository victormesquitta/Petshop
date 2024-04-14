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

    .MeusPedidos {
      font-size: 2vw;
      margin-bottom: 1rem;
    }

    .ConfiraPedidos {
      margin-bottom: 2rem;

      color: lightgreen;
    }

    .divMeusPedidos {
      width: 90%;
      padding-right: 1.5rem;
      height: 25rem;

      display: flex;
      flex-direction: row;
      align-items: start;
      justify-content: space-around;

      border: 1px solid;
      border-color: lightgray;
      border-radius: 15px;

      overflow: hidden;

      section {
        display: flex;
        align-items: center;
        gap: 1rem;

        border: 1.5px solid;
        border-color: lightgray;
        border-radius: 25px;

        width: 85%;
        height: 10rem;

        padding: 2rem;
        margin-top: 1.5rem;
        margin-left: 3rem;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        div {
          width: 100%;

          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;

          h1 {
            font-size: 1.3vw;
            color: gold;

            width: 120%;

            margin-bottom: 1rem;

          }

          h3 {
            width: 120%;
            font-size: 1vw;
          }
        }
        img {
          width: 35%;

          margin-right: 1rem;
        }
      }
    }
  }
`;
