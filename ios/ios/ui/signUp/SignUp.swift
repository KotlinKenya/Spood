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
        VStack {
            Text(viewModel.email)
            Button("Sign Up"){ viewModel.signUp() }
        }
        .navigationBarHidden(true)
    }
}
