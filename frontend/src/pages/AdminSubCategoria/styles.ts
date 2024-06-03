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

    gap: 6rem;

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

        width: 2%;
        height: 2%;
      }

      img {
        width: 10%;

        border-radius: 90%;
      }
    }

    div {
      width: 100%;
      height: 100%;

      display: flex;
      align-items: start;
      justify-content: space-around;

      .section2 {
        width: 45%;
        height: 100%;

        display: flex;
        flex-direction: column;
        align-items: flex-start;
        justify-content: flex-start;

        h1 {
          font-size: 2.2vw;
        }

        label {
          margin-top: 2rem;
        }
        

        input {
          border-radius: 10px;
          border: 1px solid;
          border-color: lightgray;

          width: 40%;
          height: 7%;

          margin-top: 0.4rem;
          padding-left: 1rem;
          padding-right: 2rem;

          &:focus {
            background: #f5f5f5;
            border: 0.1px solid lightgray;
            outline: none !important;
          }
        }

        .LabelPrecoCat {
          margin-top: 4rem;
        }

        .InputDescriCat {
          border-radius: 10px;

          padding-left: 1rem;
          padding-right: 1rem;
          padding-top: .5rem;
          padding-bottom: .5rem;

          &:focus {
            background: #f5f5f5;
            border: 0.1px solid lightgray;
            outline: none !important;

          }
        }
        .CadastrarCategoria{
            margin-top: 4rem;
            padding: 10px 30px;
            border-radius: 10px;
            border-color: rgba(7, 57, 80, 1);
            background: white;
           
            color: rgba(7, 57, 80, 1);
            font-size: 16px;
            
            
            }
          }
        }
  }
`;
