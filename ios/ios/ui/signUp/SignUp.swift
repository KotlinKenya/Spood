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
        let state = viewModel.signUpState
        
        ScrollView{
            VStack {
                Logo(tint: Color("green"), width: 72)
                
                Header(title: "Sign Up", subTitle: "Let's do this once and for all")
                
                Inputs(state: state, viewModel: viewModel)
                
                if state.loading { ProgressView("Please wait…") }
                
                PrimaryActionButton(text: "Sign Up", action: viewModel.signUp)
                
                SecondaryActionButton(textPrimary: "Already have an account?",textSecondary: "Sign in", action: viewModel.signUp)
                
                SecondaryActionButton(textPrimary: "I'LL SIGN UP LATER", icon: "ic_arrow_right", action: viewModel.signUp)
                
                Spacer()
            }
            .padding(.horizontal)
        }
        .navigationBarHidden(true)
        .alert(isPresented: Binding<Bool> (get: { state.signUpError != nil }, set:{_ in })) {
            Alert(
                title: Text("Sign Up Error").font(.title),
                message: Text(state.signUpError?.message ?? "").font(.body),
                dismissButton: .cancel { viewModel.signUpErrorDismissed() }
            )
        }
    }
    
    func Inputs(state: SignUpState, viewModel: SignUpViewModel) -> some View {
        VStack (alignment: .center, spacing: 20){
            InputField(
                text: state.fullName,
                error: state.fullNameError,
                hint: "Enter your full name",
                label: "Full Name",
                type: .name
            ){ value in viewModel.fullNameChanged(fullName: value)}
            
            InputField(
                text: state.phoneNumber,
                error: state.phoneNumberError,
                hint: "0700 000 000",
                label: "Phone Number",
                type: .telephoneNumber
            ){ value in viewModel.phoneNumberChanged(phoneNumber: value)}
        }
        .padding(.vertical, 25.0)
    }
}
