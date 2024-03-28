import styled from "styled-components";

export const ContainerPai = styled.div`
*{
    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;
}

width: 100%;
height: 100%;

`
export const DivMain = styled.div`

display: flex;
align-items: center;
flex-direction: column;

.DivImgTransition{
    margin-top: 3rem;

    width: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    
    gap: 3.5rem;

    img{
        width: 60%;
        background-color: white;
    }

    h2{
        font-size: 1.4vw;
        letter-spacing: .1rem;
    }
}

.DivCards{
    width: 90%;

    margin-bottom: 2rem;

    display: flex;
    align-items: center;
    justify-content: space-around;

    section{
        flex-direction: column;
        display: flex;
        align-items: center;
        justify-content: space-evenly;

        border: 1.5px solid;
        border-color: lightgray;
        border-radius: 25px;

        width: 22%;
        height: 30rem;

        padding: 2rem;
        margin-top: 3.5rem;
        
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        
        img{
            width: 80%;
            height: 11rem;

        }

        h3{
            margin-top: .5rem; 
            padding-left: .7rem;

            font-size: 1vw;
        }  

        .IconCoracao{
            position: relative;
            left: 7rem;

            color: red;

            width: 20%;
            height: 1.3rem;

            cursor: pointer;
        }
        .Pedigree{
            font-size: .9vw;
            color: lightslategray;

            width: 100%;

            align-items: start;

            margin-top: .7rem;

        }
            .PrecoRiscado{
                text-decoration: line-through;

                font-size: .8vw;
                color: lightslategray;

                margin-top: 1rem;

                position: relative;
                right: 2rem;
            }
            .PrecoNormal{
                font-size: 1.5vw;
                font-weight: 800;
                
            }
            .MimuPoints{
                color: gold;
                font-size: .9vw;

                margin-top: 1rem;
            }

            button{    
                margin-top: 1rem;
                                
                align-items: center;
                justify-content: center;

                font-weight: 600;

                border: none;
                border-radius: 15px;
                border-color: #073950;

                width: 80%;
                height: 2.2rem;

                background-color: #073950;
                color: white;  

                    
            }
    }
}
.ParaPrincipaisMarcas{
    margin-top: 2.5rem;
    margin-bottom: 3rem;

    .PrincipaisMarcasTitulo{
        font-size: 1.4vw;
        letter-spacing: .1rem;

    }
}
    
    @media (max-width: 1024px){
        .DivImgTransition{
            h2{ 
                font-size: 2.5vw;
            }
        }    

        .DivCards{
            section{
                height: 20rem;

                img{
                    width: 60%;
                }

                h3{
                    font-size: 1.3vw;
                }

                .IconCoracao{
                    left: 5.5rem;
                }

                p{
                    font-size: 1vw;
                }
            }
        }
    }
`
export const ContainerMarcas = styled.section`
flex-direction: column;

padding-top: 1.5rem;
padding-bottom: 1.5rem;
background-color: #073950;

section{
    display: flex;
    justify-content: space-evenly;
    align-items: center;

    width: 100%;

    img{
    width: 10%;
}
}
.SectionImgs{
    img{
        margin-top: 1rem;
    }

    .ImgElano{
        background-color: white;

        height: 8.4rem;
    }
}

`