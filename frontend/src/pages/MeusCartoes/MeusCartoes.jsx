import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import * as S from "./styles";
import cartao from "../../assets/images/creditcard.png";
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";
import { AuthService } from "../../services/AuthService";
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';


export function MeusCartoes(props) {

    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />

                <S.ContainerMain>

                    <InformacoesComponent />
                    <div>
                        <div className="DivTitle">
                            <h1 className='MeusCartoes'>Meus Cartões</h1>
                            <h2 className='NovoCartao'>Adicione seu novo cartão</h2>
                        </div>

                        <div className="DivCadastroCartao">
                            <div>
                                <img src={cartao} className="FotoCartao"></img>
                                <h2 className="Titulo">Cadastre Seu Cartão</h2>
                                <h3 className="Subtitulo">Insira os dados do seu cartão</h3>
                            </div>


                            <section className='section'>
                                <section>
                                    <label className='LabelNumCad'>Numero do Cartão</label>
                                    <input className='InputNumCad' type="" placeholder="Numero do Cartão" />

                                    <label>Data</label>
                                    <input className='InputCvc' type="month" placeholder="CVC" />
                                </section>

                                <section>
                                    <label>CVC</label>
                                    <input className='InputCvc' placeholder="CVC" />

                                    <label >Nome Completo</label>
                                    <input className='InputNome' placeholder="Nome Completo" />
                                </section>
                            </section>

                            <button className="Cadastro">Cadastrar</button>
                        </div>
                    </div>

                </S.ContainerMain>
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}