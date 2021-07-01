import Foundation
import Combine
import common

class SignUpViewModel: ObservableObject {
    
    private let __signUpState  = SignUpState.init(fullName: "", fullNameError: nil, phoneNumber: "", phoneNumberError: nil, loading: false, signUpError: nil, signedUp: false)
    @Published var signUpState: SignUpState
    
    private let signUpUseCase :  SignUpUseCase
    init() {
        self.signUpState = self.__signUpState
        self.signUpUseCase = SignUpUseCase()
        signUpUseCase.state.collectCommon( callback: { signUpState in
            self.signUpState = signUpState ?? self.__signUpState
        }) { _, _ in }
    }
    
    func fullNameChanged(fullName: String) {
        signUpUseCase.fullNameChanged(fullName: fullName)
    }
    
    func phoneNumberChanged(phoneNumber: String) {
        signUpUseCase.phoneNumberChanged(phoneNumber: phoneNumber)
    }
    
    func signUpErrorDismissed() {
        signUpUseCase.signUpErrorDismissed()
    }
    
    func signUp() -> Void {
        signUpUseCase.signUp(){data, error in }
    }
}
