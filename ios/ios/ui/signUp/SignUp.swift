import SwiftUI

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
        ScrollView{
            VStack {
                Logo(tint: Color("green"), width: 72)
                Header(title: "Sign Up", subTitle: "Let's do this once and for all")
                VStack (alignment: .center, spacing: 20){
                    InputField(text: $viewModel.fullName, hint: "Enter your full name", label: "Full Name", type: .name)
                    InputField(text: $viewModel.phoneNumber, hint: "0700 000 000", label: "Phone Number", type: .telephoneNumber)
                }
                .padding(.vertical, 25.0)
                Error(error: viewModel.error)
                PrimaryActionButton(text: "Sign Up", action: viewModel.signUp)
                SecondaryActionButton(textPrimary: "Already have an account?",textSecondary: "Sign in", action: viewModel.signUp)
                SecondaryActionButton(textPrimary: "I'll sign up later", icon: "ic_arrow_right", action: viewModel.signUp)
                Spacer()
            }
            .padding(.horizontal)
        }
        .navigationBarHidden(true)
    }
}
