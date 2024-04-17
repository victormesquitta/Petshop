import styled from "styled-components";

export const NavBarLogado = styled.nav`
  * {
    font-size: 1vw;
    font-family: "Roboto", sans-serif;
  }
  width: 100%;
  height: 19%;
  margin-top: 0.5rem;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;

  font-size: 1vw;
  font-family: "Roboto", sans-serif;

  div {
    width: 100%;

    display: flex;
    align-items: center;

    img {
      height: 10vh;

      border-radius: 70px;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    }

    &:first-child {
      padding-left: 6rem;
      padding-right: 2rem;
    }

    &:last-child {
      height: 40%;

      background-color: #88ce08;

      justify-content: space-evenly;
    }

    .SectionBarraDePesquisa {
      display: flex;
      align-items: center;

      flex: 1;
      margin-left: 4rem;

      input {
        border: 1px solid;
        border-color: #88ce08;
        border-radius: 15px;

        padding-left: 4rem;
        padding-right: 2rem;

        width: 100%;
        height: 2.7rem;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        &:focus {
          background: whitesmoke;
          border: 0.1px solid rgb(104, 178, 224);
          outline: none !important;
        }
      }
      .IconLupa {
        position: absolute;

        height: 1.5rem;
        width: 5%;

        color: gray;
      }
    }

    .SectionIcons {
      width: 20%;
      display: flex;
      justify-content: space-evenly;
      align-items: center;

      .IconFavoritos {
        height: 4.5vh;
        width: 10%;

        color: #88ce08;

        margin-left: 4rem;

        cursor: pointer;
      }

      .IconCarrinho {
        height: 4.5vh;
        width: 10%;

        color: #88ce08;

        cursor: pointer;
      }
    }
    .BotaoFimTela {
      border: 1px solid;
      border-radius: 15px;
      border-color: #88ce08;

      color: #88ce08;
      background-color: white;

      width: 12%;
      height: 2.2rem;
      margin-right: 1.5rem;

      font-size: 1vw;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

      display: flex;
      justify-content: center;
      align-items: center;

      .IconAdmin {
        width: 30%;
        height: 1.1rem;

        margin-right: -0.5rem;

        display: flex;
        justify-content: center;
        align-items: center;
      }
    }
    .BotaoLogout {
      border: 1px solid;
      border-radius: 15px;
      border-color: #88ce08;

      color: #88ce08;
      background-color: white;

      width: 6%;
      height: 2.2rem;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    }

    .BotaoLogin {
      border: 1px solid;
      border-radius: 15px;

      width: 7%;
      height: 2.2rem;

      color: #88ce08;
      background-color: white;

      box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    }
  }
  .DivBotoesDepartamentos {
    width: 100%;
    height: 3rem;

    display: flex;
    flex-direction: column;
    align-items: start;
    justify-content: center;

    .Dropdown {
      width: 25%;
      height: 2.7rem;

      padding-top: 0.4rem;

      display: block;
      flex-direction: column;
      justify-content: flex-start;

      .dropdown-menu{
        display: block;
      }

      .ButtonDepartamentos {
        display: block;

        border: none;
        border-radius: 12px;

        width: 80%;
        height: 2rem;

        background-color: #073950;
        color: white;

        z-index: 2;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        .iconDepartamento {
          margin-right: 0.3rem;
          margin-top: 0.3rem;
        }
      }

      .dropdown-menu {
        width: 80%;

        position: relative;

        top: -.1rem;

        color: #073950;
        background-color: white;

        border-color: none;
        border-radius: 15px;

        z-index: 1;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
     
        button{
          background-color: white;
          color: #073950;

          width: 100%;
          height: 3rem;
          
          display: flex;
          align-items: center;

          border: none;
          border-radius: 5px;

          &:hover {
          box-shadow: inset 0 0 5px #073950;

      }

          img{
            width: 22%;
            height: 70%;

            margin-right: .5rem;
            margin-left: .5rem;
          }
        }
      }
    }
  }
  @media (max-width: 1024px) {
    .SectionBarraDePesquisa {
      input {
        font-size: 2vw;
      }
    }
    div {
      .SectionIcons {
        .IconFavoritos {
          width: 20%;
          height: 2rem;
        }

        .IconCarrinho {
          width: 20%;
          height: 1.7rem;
        }
      }

      .BotaoFimTela {
        width: 16%;

        font-size: 1.7vw;

        .IconAdmin {
          height: 1.5rem;

          padding-right: 1rem;
        }
      }
    }

    .DivBotoesDepartamentos {
      button {
        width: 12.5%;
        height: 2rem;

        font-size: 1.6vw;

        img {
          display: none;
        }
      }
      .ButtonDepartamentos {
        padding: 0.5rem;
      }
    }
  }
`;
