import Foundation

class SignUpViewModel: ObservableObject {
    
    @Published var email : String = ""
    @Published var phoneNumber : String = ""
    
    func signUp() -> Void {
        self.email = "dummy email"
    }
}
