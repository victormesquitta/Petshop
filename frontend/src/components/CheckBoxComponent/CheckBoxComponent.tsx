import { useState } from "react";
import { SaveLogin } from "./styles";


export function CheckedBoxComponent() {
    const [isChecked, setIsChecked] = useState(false);

    const handleCheckBoxChange = () => {
        setIsChecked(!isChecked);
    };

    return (
        <>
            <SaveLogin>
                <input type="checkbox" checked={isChecked} onChange={handleCheckBoxChange} />

                <label>Mantenha-se logado</label>
            </SaveLogin>
        </>
    );
}