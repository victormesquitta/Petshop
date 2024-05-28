import * as S from './styles';
import ImgLogo from "../../assets/images/ImgLogo.svg";

export function Erro404(){
    return(
        <S.ContainerPai>
                <S.ContainerMain>
                <div className='logo'>
                    <img src ={ImgLogo}/>
                </div>
                <div>
                    <h1>404</h1>
                    <h4>Tela Não Encontrada</h4> 
                </div>      

                <div className='Subtitulo'>
                    <h4>Não encontramos nenhuma página</h4>
                </div>        

                </S.ContainerMain>
               
        </S.ContainerPai>
    );
}