import styled from 'styled-components';

const StyledModal = styled.div`

    width: 100vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #f0f8ffb7;
    backdrop-filter: blur( 2px );
    position: absolute;
    top: 0;
    left: 0;

    #container {

        animation: to_top 1s ease-in-out;
        width: 600px;
        height: 600px;
        border-radius: 16px;
        padding: 24px;
        background-color: #f2f2f2;
        border: 2px solid gray;
        position: relative;
    }

    button {

        animation: btn 1s ease;
        width: 30px;
        height: 30px;
        color: white;
        border-radius: 4px;
        position: absolute;
        top: -10px;
        right: -10px;
    }
`

const Modal = ({isOpen, setOpenModal, children}) => {

    if (isOpen) {
        return (
            <StyledModal>
                <div id='container'>
                    
                    {children}
                    
                    <button onClick={setOpenModal}>
                        X
                    </button>
                    
                </div>
            </StyledModal>
        ) 
    }

    return null
}

export default Modal