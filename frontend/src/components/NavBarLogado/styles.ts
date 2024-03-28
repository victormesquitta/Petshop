import styled from "styled-components";

export const NavBarLogado = styled.nav`

*{
    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;
}
    width: 100%;
    height: 19%;
    margin-top: .5rem;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;

    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;

    div{
        width: 100%;

        display: flex;
        align-items: center;

        img{
            height: 10vh;

            border-radius: 70px;

            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

        }
        &:first-child{
        padding-left: 6rem;
        padding-right: 2rem;
        }
        
        &:last-child{
            height: 40%;

            background-color: #88CE08;

            justify-content: space-evenly;
        }

        .SectionBarraDePesquisa{
            display: flex;
            align-items: center;

            flex:1;
            margin-left: 4rem;

            input{
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
            .IconLupa{
                position: absolute;

                height: 1.5rem;
                width: 5%;

                color: gray;

            }
        }

        .SectionIcons{
            width: 20%;
            display: flex;
            justify-content: space-evenly;
            align-items: center;

            .IconFavoritos{
                height: 4.5vh;
                width: 10%;

                color: #88CE08;

                cursor: pointer;
            }

            .IconCarrinho{
                height: 4.5vh;
                width: 10%;

                color: #88CE08;      
                
                cursor: pointer;
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
    }
        .DivBotoesDepartamentos{
                button{
                    display: flex;
                    
                    align-items: center;
                    justify-content: space-evenly;

                    font-weight: 600;

                    border: none;
                    border-radius: 15px;

                    width: 10%;
                    height: 1.8rem;

                    background-color: white;
                    color: #073950;  
                    
                    img{
                        height: 1.5rem;
                        width: 20%;
                    }
                } 
                .ButtonDepartamentos{
                    background-color: #073950;
                    color: white;
                }
            }
@media (max-width: 1024px) {
    .SectionBarraDePesquisa{
        input{
            font-size: 2vw;
        }
    }
div{
    .SectionIcons{
    .IconFavoritos{
        width: 20%;
        height: 2rem;
    }

    .IconCarrinho{
        width: 20%;
        height: 1.7rem;
    }
}

.BotaoFimTela{
    width: 16%;

    font-size: 1.7vw;

    .IconAdmin{
        height: 1.5rem;

        padding-right: 1rem;
    }

}

}

.DivBotoesDepartamentos{
    button{
        width: 12.5%;
        height: 2.2rem;

        font-size: 1.6vw;

        img{
            display: none;
        }
    }
        .ButtonDepartamentos{
            padding: .5rem;
        }
}
}
`