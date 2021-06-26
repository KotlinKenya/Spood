import SwiftUI
import common

struct SplashScreen_Previews: PreviewProvider {
    static var previews: some View {
        SplashScreen()
    }
}

struct SplashScreen: View {
    
    @StateObject var viewModel : SplashScreenViewModel
    
    init(viewModel: SplashScreenViewModel = .init()) {
        _viewModel = StateObject(wrappedValue: viewModel)
    }
    
    var body: some View {
        ZStack{
            NavigationLink( destination: SignUp(), isActive: $viewModel.shouldNavigateToSignUp ){ EmptyView() }
            content(viewModel: viewModel)
            floatingButton(viewModel: viewModel)
        }
        .background(Color("yellow").ignoresSafeArea())
        .navigationBarHidden(true)
    }
    
    
    func content(viewModel : SplashScreenViewModel) -> some View {
        VStack{
            Spacer()
            Button(
                action:  viewModel.goToSignUp,
                label: {
                    Image("logo")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/)
                        .padding(.horizontal, 120)
                }
            )
            Spacer()
            Image("banner")
            Spacer()
            Image("tagline")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/)
                .padding(.horizontal, 50.0)
            Spacer()
        }
    }
    
    func floatingButton(viewModel : SplashScreenViewModel) ->  some View {
        VStack {
            Spacer()
            HStack {
                Spacer()
                Button(
                    action: viewModel.goToSignUp,
                    label: {
                        Image("ic_arrow_right")
                            .frame(width: 56, height: 56)
                            .background(Color("white"))
                            .cornerRadius(28)
                    }
                )
                .padding()
                .shadow(radius: 3)
            }
        }
    }
}
