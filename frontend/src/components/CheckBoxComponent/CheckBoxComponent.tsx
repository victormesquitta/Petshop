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

                <label><input
                    type="checkbox"
                    checked={isChecked}
                    onChange={handleCheckBoxChange}
                />Mantenha-se Logado</label>
            </SaveLogin>

        </>
    );
}