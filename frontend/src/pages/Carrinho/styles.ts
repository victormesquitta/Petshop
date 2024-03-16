import styled from "styled-components";

export const ContainerPai = styled.div`
width: 100%;
height: 100%;

`
export const NavBar = styled.nav` width: 100%;
height: 19%;

display: flex;
flex-direction: column;
align-items: center;
justify-content: space-between;

font-size: 1vw;;
font-family: 'Roboto', sans-serif;

div{
        width: 100%;

        padding-left: 4rem;
        padding-right: 3rem;

        display: flex;
        align-items: center;
        justify-content: space-between;

        height: 4.1rem;
        background-color: #88CE08;

        img{
            height: 10vh;

            border-radius: 70px;

            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        }
    }
            .BotaoFimTela{
                    border: 1px solid;
                    border-radius: 15px;
                    border-color: #88CE08;

                    color: #88CE08;
                    background-color: white;
                    
                    width: 15%;
                    height: 2.7rem;

                    font-size: 1vw;;

                    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                    
                    display: flex;
                    justify-content: center;
                    align-items: center;

                    .IconAdmin{                        
                        width: 30%;
                        height: 1.1rem;

                        margin-right: -.5rem;

                        display: flex;
                        justify-content: center;
                        align-items: center;
                        
                    }
            }
`

export const ContainerMain = styled.section`
display: flex;
flex-direction: column;

justify-content: center;

margin-left: 2rem;
margin-right: 2rem;

.DivCarrinhoLixo{
    display: flex;

    width: 60%;

    margin-top: 1rem;
    padding-left: 2.5rem;

    align-items: center;
    justify-content: space-between;
    

    h3{
        font-size: 1.5vw;

        &:last-child{
            color: #CC2B2B;
        }
    }
}

.DivProdutos{
    display: flex;
    align-items: center;
    justify-content: space-around;

    margin-top: 1rem;
    
    .SecInfoProduto{
    display: flex;
    align-items: center;
    justify-content: space-around;

    width: 60%;

    border: 1px solid;
    border-radius: 15px;
    border-color: lightgray;

    padding: 1.5rem;          
    
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);


    p{
        margin-left: 1rem;

        font-size: 1.3vw;
        font-weight: 600;

    }

    input{
        padding-left: .9rem;

        width: 6%;
        height: 2.3rem;

        border-radius: 10px;
        border: 1px solid;
        border-color: lightgray;

    }

    .Titulo{
        width: 40%;

    }

    .IconLixo{
        color: #CC2B2B;

        position: absolute;

        width: 10%;
        height: 1.5rem;

        right: 28rem;
        top: 13rem;

        cursor: pointer;
    }

    .ImgCard{
        width: 15%;
        height: 7rem;
       
    }
}

.SecInfoPrecos{
    border: 1px solid;
    border-radius: 15px;
    border-color: lightgray;

    display: flex;
    flex-direction: column;
    gap: .5rem;


    padding: 1rem; 

    width: 33%;

    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

    div{
        display: flex;
        align-items: center;
        justify-content: space-between;

    }

    .DivBotoes{
        display: flex;
        flex-direction: column;

        gap: 1rem;

        button{
        border: 1px solid;
        border-radius: 10px;
        border-color: #073950;
        background-color: #073950;
        color: white;

        height: 2rem;
        width: 70%;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        &:last-child{
            border: none;
            
            background-color: white;
            color: #073950;
        }
    }
    }
}
}
.DivFretePrazo{
    display: flex;
    justify-content: space-between;
    width: 60%;

    margin-left: 1.5rem;
    margin-top: 1.5rem;

    h3{
        font-size: 1.5vw;

        display: flex;
        align-items: center;

        .TicketIcon{
            margin-left: .5rem;
        }
    }
}

.DivCupomFrete{
    display: flex;
    align-items: center;
    justify-content: start;
    gap: 8rem;

    section{
        border: 1px solid;
        border-radius: 10px;
        border-color: lightgray;

        padding: .8rem;

        width: 30%;
        height: 4rem;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);


        input{
            padding-left: 2rem;
            padding-right: 2.5rem;
            margin-right: 1rem;

            width: 60%;
            height: 2.5rem;

            border: 1px solid;
            border-radius: 10px;
            border-color: lightgray;
        }

        button{
            border: 1px solid;
            border-radius: 10px;
            color: white;
            background-color: #073950;

            height: 2.5rem;
            width: 30%;

            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        }
    }
}

.TituloPodeInteressar{
    margin-top: 1rem;
}

`;