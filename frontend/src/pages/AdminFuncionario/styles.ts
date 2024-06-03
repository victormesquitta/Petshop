import styled from "styled-components";

export const ContainerPai = styled.main`
  width: 100%;
  height: 100%;

  display: flex;
  align-items: center;
  justify-content: center;

  .divDashBoard {
    width: 20%;
    height: 100%;

    background-color: #0c445e;

    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: flex-start;

    color: white;

    img {
      width: 25%;

      margin-top: 0.5rem;
      margin-left: 0.5rem;
    }

    h1 {
      margin-bottom: 5rem;
      margin-top: 5rem;
      margin-left: 2rem;
    }

    .Link {
      color: white;
      text-decoration: none;
      letter-spacing: 0.1rem;
      font-size: 1.4vw;

      display: flex;
      align-items: center;

      width: 100%;
      height: 10%;

      padding-left: 3rem;

      &:hover {
        box-shadow: inset 0 0 10px white;
      }
      .icons {
        margin-right: 1rem;
      }
    }
  }

  .divPrincipal {
    width: 80%;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;

    gap: 2.5rem;

    .section1 {
      width: 85%;

      margin-top: 0.7rem;

      display: flex;
      justify-content: space-between;
      align-items: center;

      .InputPesquisar {
        width: 35%;
        height: 2.5rem;

        border-radius: 15px;
        border: 1px solid gray;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        padding-left: 3rem;
        padding-right: 2rem;

        &:focus {
          background: #f5f5f5;
          border: 0.1px solid lightgray;
          outline: none !important;
        }
      }

      .IconLupa {
        position: absolute;

        color: gray;

        width: 4%;
        height: 4%;
      }

      img {
        width: 10%;

        border-radius: 90%;
      }
    }

    .section2 {
      width: 90%;
      height: 40%;

      display: flex;
      flex-direction: column;
      align-items: flex-start;
      justify-content: flex-start;

      h1 {
        font-size: 2.2vw;

        margin-bottom: 1.5rem;
      }

      div {
        width: 100%;
        margin-top: 1.5rem;

        display: flex;
        align-items: center;
        justify-content: center;

        button{
          border-radius: 10px;
          border: 1px solid lightgray;

          height: 1.5rem;
          width: 15%;
        }
      }

      .section3 {
        display: flex;

        width: 100%;

        section {
          display: flex;
          flex-direction: column;
          align-items: flex-start;
          justify-content: space-between;

          width: 100%;

          label {
            margin-top: 2rem;
          }

          input {
            border-radius: 10px;
            border: 1px solid;
            border-color: lightgray;

            width: 55%;
            height: 1.8rem;

            margin-top: 0.4rem;
            padding-left: 1rem;
            padding-right: 2rem;

            &:focus {
              background: #f5f5f5;
              border: 0.1px solid lightgray;
              outline: none !important;
            }
          }
        }
      }
    }
  }
`;
