import styled from "styled-components";

export const ContainerPai = styled.main`
  width: 100%;
  height: 100%;

  display: flex;
  align-items: center;
  justify-content: center;

  .toastContainer {
    width: 20%;

    margin-top: 3.5rem;
  }

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

      padding-left: 2rem;

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

    div {
      width: 100%;
      height: 70%;

      display: flex;
      align-items: start;
      justify-content: center;

      margin-top: 3rem;

      .section2 {
        width: 45%;
        height: 100%;

        display: flex;
        flex-direction: column;
        align-items: flex-start;
        justify-content: flex-start;

        padding-left: 2rem;

        h1 {
          font-size: 2.2vw;

          margin-bottom: 1rem;
        }

        label {
          margin-top: 1rem;
        }

        input {
          border-radius: 10px;
          border: 1px solid;
          border-color: lightgray;

          width: 50%;
          height: 9%;

          margin-top: 0.4rem;
          padding-left: 1rem;
          padding-right: 1rem;

          &:focus {
            background: #f5f5f5;
            border: 0.1px solid lightgray;
            outline: none !important;
          }
        }

        .LabelPrecoProd {
          margin-top: 4rem;
        }

        .InputDescriProd {
          border-radius: 10px;

          padding-left: 1rem;
          padding-right: 1rem;
          padding-top: 0.5rem;
          padding-bottom: 0.5rem;

          &:focus {
            background: #f5f5f5;
            border: 0.1px solid lightgray;
            outline: none !important;
          }
        }
      }
    }
    .section3 {
      display: flex;
      align-items: center;
      justify-content: space-between;

      margin-top: 0.5rem;

      height: 4%;

      input {
        border-radius: 10px;
        border: 1px solid;
        border-color: gray;

        width: 25%;
        height: 100%;

        padding-left: 0.5rem;
      }

      button {
        border: 1px solid;
        border-color: gray;
        border-radius: 10px;

        height: 100%;

        background-color: white;

        padding-left: 0.5rem;
        padding-right: 0.5rem;
      }
    }
  }
`;
