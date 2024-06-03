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

  .divMain {
    width: 100%;
    height: 100%;

    padding-left: 2rem;

    display: flex;
    flex-direction: column;

    .meusPets {
      display: flex;
      justify-content: space-between;
      align-items: start;

      h1 {
        font-size: 2vw;

        color: gray;
      }

      button {
        border: 1px solid;
        border-radius: 10px;
        border-color: #88ce08;

        height: 2.5rem;
        width: 18%;

        background-color: white;
        color: #88ce08;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
      }
    }

    .divInformacoes {
      display: flex;
      align-items: center;
      justify-content: space-around;

      margin-top: 1.5rem;

      width: 60%;
      height: 50%;

      .sectionInfosPet {
        display: flex;
        align-items: center;
        justify-content: space-evenly;

        gap: 3rem;

        border: 2px solid;
        border-color: lightgray;
        border-radius: 10px;

        width: 55%;
        height: 75%;

        padding-top: 0.5rem;

        .iconReticencias {
          position: relative;

          bottom: 3.5rem;
          margin-right: 0.5rem;

          cursor: pointer;
        }

        img {
          width: 37%;

          border-radius: 150%;
        }

        div {
          h3:hover {
            text-decoration: underline;
          }

          p {
            margin-top: 0.3rem;

            &:hover {
              text-decoration: underline;
            }
          }
        }
      }

      .CirculoMais {
        width: 20%;
        height: 25%;

        color: #88ce08;

        cursor: pointer;
      }
    }
  }
`;
