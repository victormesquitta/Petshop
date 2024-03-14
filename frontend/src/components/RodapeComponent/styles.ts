import styled from "styled-components";

export const ContainerPai = styled.footer`
*{
    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;
}


.Copyright{
    margin-top: 2rem;
    width:100%;
    height: 2.5rem;

    display: flex;
    justify-content: center;
    align-items: center;

    background-color: #88CE08;
    color: white;

    p{
        letter-spacing: .2em;
        font-size: .8vw;
    }
}

`;

export const ContainerNav = styled.section`
background-color: #88CE08;

height: 5rem;

display: flex;
align-items: center;
justify-content: space-around;

z-index:-1;

    div{
        background-color: #88CE08;
        height: 100%;
        width: 15%;

        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-evenly;

        padding: 1rem 0rem 1rem 2rem;

        line-height: 3.5vh;
        color: white;

        strong{
            font-size: 1.4vw;
        }
    }

    .InputEmail{
        flex:1;
        margin-left: 3rem;

        border: 1px solid;
        border-color: #88CE08;
        border-radius: 15px;

        padding-left: 4rem;
        padding-right: 2rem;

        width: 100%;
        height: 2.7rem;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

            &:focus{
                background: whitesmoke;
                border: 0.1px solid rgb(104, 178, 224);
                outline: none !important;
            }  
    }

    .Dropdown{
        width:20%;

        padding-right: 2rem;

        display: block;

        .BotaoSeuPet{
        border: 1px solid;
        border-radius: 15px;
        border-color: #88CE08;

        width: 80%;
        height: 2.7rem;     

        background-color: white;

        position: static;
        z-index: 2;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        
    }

    .dropdown-menu{
        width: 80%;

        position: relative;
       
        top: -.2rem;

        color:black;
        background-color: white;

        border-color: #88CE08;
        border-radius: 15px;

        z-index: 1;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        li{
            display: flex;
            align-items: center;
            justify-content: center;
            
            border-radius: 15px;

            list-style: none;

            width: 100%;
            height: 2.5rem;

            cursor: pointer;

            &:last-child{
                box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

            }
        }
    }
}
    .Cadastrar{
        background-color: white;

        border: 1px solid;
        border-radius: 15px;
        border-color: #88CE08;

        width: 7%;
        height: 2.7rem;

        margin-right: 7rem;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        .Link{
            text-decoration: none;
        }
    }
`

export const ContainerInformacoesSite = styled.section`
display: flex;

height: 15rem;

flex-direction: column;
justify-content: center;
align-items: center;

        h3{
            color: #88CE08;
            font-size: 1.2vw;

        }

    .DivInformacoes{
        width: 100%;
        margin-top: 2rem;
    
        display: flex;
        align-items: center;
        justify-content: space-evenly;

        div{
            display: flex;

            flex-direction: column;
            justify-content: center;

            line-height: 1rem;
            color: gray;

            h3{
            margin-bottom: 1rem;
            } 

            .FaleConosco{
                margin-top: .7rem;
            }

            .SacMimu{
                margin-top: .7rem;
            }

            .SelosCertificados{
                margin-top: 1.2rem;
            }

            .GoogleNavegacaoSegura{
                width: 80%;
                height: 3rem;
            }

            .GoogleSafeBrowsing{
                width: 100%;
                height: 3rem;
            }
        }
        .ImgPremioEpoca{
            position: relative;
            right: 6.5rem;
            top: .5rem;

            height: 5rem;

        }

        .ImgLogo{
            border-radius: 80px;
            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

            height: 20vh;
        }
    }

    .DivRedesSociais{
        width: 100%;
        height: 6rem;

        margin-top: 1.5rem;

        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: start;

        .RedesSociais{
            width: 35%;
            height: 3.1rem;
            margin-top: .5rem;

            display: flex;
            justify-content: space-evenly;
            align-items: center;

            .ImgWhatsapp{
                color: #88CE08;
                height: 2rem;
                width: 17%;

                cursor: pointer;
            }

            .ImgFacebook{
                color: #88CE08;
                height: 2rem;
                width: 17%;

                cursor: pointer;
            }

            .ImgInstagram{
                color: #88CE08;
                height: 2rem;
                width: 17%;

                cursor: pointer;
            }
        }

    }

`