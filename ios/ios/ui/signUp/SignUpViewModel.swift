import Foundation
import Combine
import common

class SignUpViewModel: ObservableObject {
    
    @Published var state: SignUpState
    let store :  SignUpStore
    
    init() {
        let initialState  = SignUpState.init(fullName: "", fullNameError: nil, phoneNumber: "", phoneNumberError: nil, loading: false, signUpError: nil, signedUp: false)
        self.state = initialState
        
        let reducer = SignUpReducer()
        let effects : [Effect] = [
            SignUpValidationEffect(),
            SignUpNetworkingEffect()
        ]
        self.store = SignUpStore(reducer: reducer, effects: effects)
        self.store.stateIos.collectCommon( callback: { state in  self.state = state ?? initialState}) { _, _ in }
    }
}
