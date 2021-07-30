import Foundation

class SplashScreenViewModel : ObservableObject {
    
    @Published var shouldNavigateToSignUp = false
    
    func goToSignUp() -> Void {
        self.shouldNavigateToSignUp.toggle()
    }
}
