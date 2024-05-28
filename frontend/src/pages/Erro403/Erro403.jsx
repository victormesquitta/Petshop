import * as S from './styles';
import ImgLogo from "../../assets/images/ImgLogo.svg";

export function Erro403(){
    return(
        <S.ContainerPai>
                <S.ContainerMain>
                <div className='logo'>
                    <img src ={ImgLogo}/>
                </div>
                <div>
                    <h1>403</h1>
                    <h4>Acesso Negado</h4> 
                </div>      

                <div className='Subtitulo'>
                    <h4>O seu usuario não tem acesso para está pagina </h4>
                </div>        

                </S.ContainerMain>
               
        </S.ContainerPai>
    );
}