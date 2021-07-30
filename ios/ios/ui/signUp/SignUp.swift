import SwiftUI
import common

struct SignUp_Previews: PreviewProvider {
    static var previews: some View {
        SignUp()
    }
}

struct SignUp: View {
    
    @StateObject var viewModel : SignUpViewModel
    init(viewModel: SignUpViewModel = .init()) {
        _viewModel = StateObject(wrappedValue: viewModel)
    }
    
    var body: some View {
        let store = viewModel.store
        let state = viewModel.state
        
        ScrollView{
            VStack {
                Logo(tint: Color("green"), width: 72)
                
                Header(title: "Sign Up", subTitle: "Let's do this once and for all")
                
                Inputs(
                    state: state,
                    onChangeFullName: {fullName in
                        store.dispatch(action: SignUpAction.ChangeFullName(fullName: fullName)) {_,_ in}
                    },
                    onChangePhoneNumber: {phoneNumber in
                        store.dispatch(action: SignUpAction.ChangePhoneNumber(phoneNumber: phoneNumber)) {_,_ in}
                    }
                )
                
                if state.loading {
                    ProgressView("Please wait…")
                } else {
                    Error(error: state.signUpError?.message ?? "")
                }
                
                PrimaryActionButton(
                    text: "Sign Up",
                    action: {store.dispatch(action: SignUpAction.InitiateSignUp()) {_,_ in}}
                )
                
                SecondaryActionButton(
                    textPrimary: "Already have an account?",
                    textSecondary: "Sign in",
                    action: {} // viewModel.signUp
                )
                
                SecondaryActionButton(
                    textPrimary: "I'LL SIGN UP LATER",
                    icon: "ic_arrow_right",
                    action: {} // viewModel.signUp
                )
                
                Spacer()
            }
            .padding(.horizontal)
        }
        .navigationBarHidden(true)
    }
    
    func Inputs(
        state: SignUpState,
        onChangeFullName: @escaping (String) -> Void,
        onChangePhoneNumber: @escaping (String) -> Void
    ) -> some View {
        VStack (alignment: .center, spacing: 20){
            InputField(
                text: state.fullName,
                error: state.fullNameError,
                hint: "Enter your full name",
                label: "Full Name",
                type: .name
            ){ value in onChangeFullName(value)}
            
            InputField(
                text: state.phoneNumber,
                error: state.phoneNumberError,
                hint: "0700 000 000",
                label: "Phone Number",
                type: .telephoneNumber
            ){ value in onChangePhoneNumber(value)}
        }
        .padding(.vertical, 25.0)
    }
}
