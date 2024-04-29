import * as S from "./styles";
import { InputSenhaComponent } from "../../components/InputSenhaComponent/InputSenhaComponent";
import ImgLogo from "../../assets/images/ImgLogo.svg";


export function AdminLogin() {

    return (
        <>
            <S.ContainerPai>
                <img src={ImgLogo} className="ImgLogo" />
                <S.FormularioLogin>
                    <S.Inputs>
                        <h1>Admin Login</h1>
                        <p>Informe seu usuario e senha de administrador.</p>
                        <InputSenhaComponent />
                    </S.Inputs>
                </S.FormularioLogin>
            </S.ContainerPai>
        </>
    )
}
